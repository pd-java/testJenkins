package com.pd.pdcmback.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.pdcmback.exception.AjaxResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pengdong
 * @date 2020/2/20 13:41
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Value("${spring.security.loginType}")
    private String loginType;

    private static ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if(loginType.equalsIgnoreCase("JSON")){
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset-UTF-8");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            /*String errormessage = "";
            if (exception instanceof LockedException) {
                errormessage = "账户被锁定，请联系管理员!";
            } else if (exception instanceof CredentialsExpiredException) {
                errormessage = "密码过期，请联系管理员!";
            } else if (exception instanceof AccountExpiredException) {
                errormessage = "账户过期，请联系管理员!";
            } else if (exception instanceof DisabledException) {
                errormessage = "账户被禁用，请联系管理员!";
            } else if (exception instanceof BadCredentialsException) {
                errormessage = "用户名或者密码输入错误，请重新输入!";
            }*/
            response.getWriter().write(objectMapper.writeValueAsString(AjaxResponse.error()));
        }
        else{
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
