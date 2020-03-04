package com.pd.pdcmback.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.pdcmback.exception.AjaxResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pengdong
 * @date 2020/2/21 9:44
 * @function
 * @describe 对登录后无权限的控制
 */

@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        System.out.println("you haven't authority");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset-UTF-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(AjaxResponse.withoutPower()));
    }
}
