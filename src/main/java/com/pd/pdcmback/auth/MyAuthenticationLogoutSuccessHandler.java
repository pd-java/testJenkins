package com.pd.pdcmback.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.pdcmback.exception.AjaxResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pengdong
 * @date 2020/3/12 17:29
 * @function
 * @describe
 */
@Component
public class MyAuthenticationLogoutSuccessHandler implements LogoutSuccessHandler {


    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("logigOut success");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset-UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.getWriter().write(objectMapper.writeValueAsString(AjaxResponse.loginOutSuccess()));
    }
}
