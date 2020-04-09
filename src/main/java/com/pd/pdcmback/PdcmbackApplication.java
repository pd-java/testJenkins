package com.pd.pdcmback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.pd.pdcmback.mapper")
@ServletComponentScan
@SpringBootApplication
public class PdcmbackApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PdcmbackApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PdcmbackApplication.class, args);
    }

}
