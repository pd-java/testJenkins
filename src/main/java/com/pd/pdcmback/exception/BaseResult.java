package com.pd.pdcmback.exception;

/**
 * @author pengdong
 * @date 2020/3/16 11:19
 * @function
 * @describe
 */
public class BaseResult {

    private static final long serialVersionUID = 4241583739802575733L;

    /** 返回状态码 */
    private Integer code;

    /** 返回信息 */
    private String message;

    /** 返回数据 */
    private Object data;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
