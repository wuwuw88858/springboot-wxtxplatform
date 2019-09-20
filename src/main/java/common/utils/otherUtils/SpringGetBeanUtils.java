package common.utils.otherUtils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @program: Wxplatform
 * @description: 获取装配Bean
 * @author: zhijie
 * @create: 2019-02-16 17:23
 **/
public class SpringGetBeanUtils implements ApplicationContextAware {
    //Spring应用上下文
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringGetBeanUtils.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
