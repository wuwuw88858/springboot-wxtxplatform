package common.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/*
*返回对象包装类
*@param:
*@return:
* */
@Data
@Component
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String SUCCESS = "200";    //成功全局码：200
    public static final String FAIL = "1";
    private Object msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object week;

    /*返回的信息*/
    private String code = SUCCESS;
    private boolean success = true;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T count;

    public ResultBean() {
        super();
    }
    public ResultBean(T data){
        super();
        this.data = data;
    }
    public ResultBean(Throwable e) {
        super();
        this.code = FAIL;
    }

    public ResultBean(T data, T count) {
        super();
        this.count = count;
        this.data = data;
    }
    public ResultBean(T data,String msg){
        super();
        this.data = data;
        this.msg = msg;
    }
    public ResultBean(T data,String msg, String week){
        super();
        this.data = data;
        this.msg = msg;
        this.week = week;
    }

}
