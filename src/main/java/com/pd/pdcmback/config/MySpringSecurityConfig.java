package com.pd.pdcmback.config;

import com.pd.pdcmback.auth.MyAccessDeniedHandler;
import com.pd.pdcmback.auth.MyAuthenticationFailureHandler;
import com.pd.pdcmback.auth.MyAuthenticationSuccessHandler;
import com.pd.pdcmback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author pengdong
 * @date 2020/2/18 14:41
 */
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Resource
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Resource
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Resource
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Bean
    public PasswordEncoder creat(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        System.out.println("don in in in in ");
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//
                .antMatchers("/","/login","/getComponentTypesAll","/uploadComponent","/getComponentType","/register","/import","/getBackMenu","/downloadComponent","/getComponentByUuid").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
                .and().authorizeRequests()
                .antMatchers("/user").hasAuthority("ROLE_USER")
                .and()
                .authorizeRequests()
                .anyRequest()       //其它路径请求
                .authenticated()    //需要登录才能访问
                .and()
                .exceptionHandling()    //没有权限时异常处理
                .accessDeniedHandler(myAccessDeniedHandler)     //没有权限，就交给myAccessDeniedHandler处理
                .and()
                .cors()         //允许跨域
                .and()
                .formLogin()       //表单登录是session/cookie认证，另外一种是httpBasic利用HTTP头部进行认证
                .loginPage("/api/login")    //为配合前端vue必须添加"/api"才能正常访问，所以由正常的"/login",改为"/api/login"
                .usernameParameter("user")  //设置传过来的用户名的格式为“user: xxx”
                .passwordParameter("pass")  //设置传过来的密码的格式为“pass: xxx”
                .loginProcessingUrl("/mypost")  //设置登录请求的url
                .successHandler(myAuthenticationSuccessHandler)    //登录成功控制
                .failureHandler(myAuthenticationFailureHandler)     //登录失败控制
                .and()
                .csrf()
                .disable()
        ;

    }
}
