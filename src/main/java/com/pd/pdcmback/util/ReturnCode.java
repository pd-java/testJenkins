package com.pd.pdcmback.util;

/**
 * @author pengdong
 * @date 2020/3/16 11:17
 * @function
 * @describe
 */
public enum  ReturnCode {

    /** 请求失败 */
    FAILED(0, "操作失败"),
    /** 请求成功 */
    SUCCESS(1, "操作成功");

    /** 返回状态码 */
    private Integer code;

    /** 返回消息 */
    private String message;

    ReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
