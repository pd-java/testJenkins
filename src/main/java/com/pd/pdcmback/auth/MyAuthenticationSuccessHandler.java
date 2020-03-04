package com.pd.pdcmback.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.pdcmback.exception.AjaxResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pengdong
 * @date 2020/2/20 10:02
 */
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value("${spring.security.loginType}")
    private String loginType;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        if(loginType.equalsIgnoreCase("JSON")){
            System.out.println("success");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset-UTF-8");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.getWriter().write(objectMapper.writeValueAsString(AjaxResponse.success()));
        }
        else{
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
