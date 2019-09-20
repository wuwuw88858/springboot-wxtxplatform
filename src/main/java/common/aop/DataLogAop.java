package common.aop;

import common.beans.ResultBean;
import common.exceptions.*;
import common.redis.JedisTemplate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/*
* @Description:  一个切面日志 使用的是注解类切面
* @Author:  zhijie
* @Date: 2019/3/23
*/
//代表这是一个组件， 相当于--->  <bean id="aop" class="common.aop.ControllerAop"/>
@Component
//这是一个切面
@Aspect
public class DataLogAop {

    @Autowired
    JedisTemplate jedisTemplate;
    private static final Logger logger = LoggerFactory.getLogger(DataLogAop.class);

    @Pointcut("execution(public common.beans.ResultBean *(..))")

    public void targets() {
    }

    /*
     * @Description:  一个日志的切面方法，可以获取请求的uri,请求的方法，方法执行的时间（未抛出异常）
     *          同时能自定义异常并且返回
     * @Param: [proceedingJoinPoint]
     * @return: java.lang.Object
     * @Author:  zhijie
     * @Date: 2019/3/23
     */
    @Around("targets()")
    public Object handlerControllerMethod(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();
        ResultBean<?> resultBean;
        Subject subject = SecurityUtils.getSubject();
       String sessionId = (String) subject.getSession().getId();
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            logger.info("url={}", request.getRequestURI());
            logger.info("method={}", request.getMethod());
            resultBean = (ResultBean<?>) proceedingJoinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (subject.getPrincipals() != null) {
                jedisTemplate.set("user:" + subject.getPrincipals(), sessionId);
                jedisTemplate.expire("user:" + subject.getPrincipals(), 600);
            }
            logger.info("[{}]use time: {}", proceedingJoinPoint.getSignature(), elapsedTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            resultBean = handlerExpcetion(proceedingJoinPoint, throwable);
        }
        return resultBean;
    }

    /*
  * @Description: 封装了自定义的异常
  * @Param: [proceedingJoinPoint, throwable]
  * @return: common.beans.ResultBean<?>
  * @Author:  zhijie
  * @Date: 2019/3/23
  */
    private ResultBean<?> handlerExpcetion(ProceedingJoinPoint proceedingJoinPoint, Throwable throwable) {
        ResultBean<?> resultBean = new ResultBean<Object>();

        if (throwable instanceof ExpiredException) {
            resultBean.setCode("40163");
            resultBean.setSuccess(false);
            resultBean.setMsg("该code已过期,请重新刷新请求");
        }
        if (throwable instanceof InvalidException) {
            resultBean.setCode("40029");
            resultBean.setSuccess(false);
            resultBean.setMsg("无效code,请重新请求");
        }
        //已知异常
        if (throwable instanceof NullException) {
            resultBean.setCode("204");      //204-无内容。
            resultBean.setSuccess(false);
            resultBean.setMsg(throwable.getLocalizedMessage());
        }
        if (throwable instanceof FailException) {
            resultBean.setCode("416");//416–所请求的范围无法满足。
            resultBean.setSuccess(false);
            resultBean.setMsg(throwable.getLocalizedMessage());
        }
        if (throwable instanceof AuthenticationException) {
            resultBean.setCode("401");  //401.1-登录失败。
            resultBean.setSuccess(false);
            resultBean.setMsg(throwable.getLocalizedMessage());
        }
        if (throwable instanceof IncorrectCredentialsException) {
            resultBean.setCode("401");
            resultBean.setSuccess(false);
            resultBean.setMsg("账号或密码错误");
        }
        if(throwable instanceof ForbidException) {
            resultBean.setCode("417");
            resultBean.setSuccess(false);
            resultBean.setMsg(throwable.getLocalizedMessage());
        }

        return resultBean;
    }


}
