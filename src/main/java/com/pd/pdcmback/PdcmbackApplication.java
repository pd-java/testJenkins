package com.pd.pdcmback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.pd.pdcmback.mapper")
@SpringBootApplication
public class PdcmbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdcmbackApplication.class, args);
    }

}
