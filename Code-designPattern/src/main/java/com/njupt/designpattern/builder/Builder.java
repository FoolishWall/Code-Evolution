package com.njupt.designpattern.builder;

/**
 * @author wall
 * @date 2019/7/9  19:59
 * @description 建造者接口，规范具体建造者的方法
 */
public interface Builder {
    void buildHead();
    void buildBody();
    void buildFoot();
    //返回一个对象
    ProductPerson build();
}
