package net.perry.online_class.exception;

/**
 * Perry Class
 * 自定义异常类
 */
public class PerryException extends RuntimeException{
    
    private Integer code;

    private String msg;

    public PerryException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
}
