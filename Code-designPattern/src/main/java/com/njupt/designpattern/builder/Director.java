package com.njupt.designpattern.builder;

/**
 * @author wall
 * @date 2019/7/9  20:12
 * @description
 */
public class Director {
    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    ProductPerson build(){
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();
        return builder.build();

    }
}
