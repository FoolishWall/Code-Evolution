package com.njupt.designpattern.proxy;

import java.lang.annotation.*;

/**
 * @author wall
 * @date 2019/7/4  21:19
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestProxy {
    String value();
}
