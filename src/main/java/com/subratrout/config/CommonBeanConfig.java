package com.subratrout.config;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jt on 4/5/17.
 */
@Configuration
public class CommonBeanConfig {

    @Bean
    public StrongPasswordEncryptor strongEncryptor(){
        return new StrongPasswordEncryptor();
    }
}