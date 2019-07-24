package com.njupt.springcode.aop;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author wall
 * @date 2019/7/20  15:29
 * @description
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfig {
    @Bean
    public Aop aop(){
        return new Aop();
    }

    @Bean
    public CalculateImp calculateImp(){
        return new CalculateImp();
    }
}
