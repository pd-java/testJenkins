package com.pd.pdcmback.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author pengdong
 * @date 2020/3/16 10:47
 * @function
 * @describe
 */
public class VerifyCodeException extends AuthenticationException {

    public VerifyCodeException(String msg){
        super(msg);
    }
}
