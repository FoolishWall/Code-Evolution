package com.njupt.designpattern.builder;

/**
 * @author wall
 * @date 2019/7/9  20:03
 * @description 具体建造者
 */
public class BuildChina implements Builder{
    ProductPerson productPerson = new ProductPerson();
    @Override
    public void buildHead() {
        System.out.println("创造中国人的Head");
        productPerson.setHead("创造中国人的Head");
    }

    @Override
    public void buildBody() {
        System.out.println("创造中国人的Body");
        productPerson.setBody("创造中国人的Body");
    }

    @Override
    public void buildFoot() {
        System.out.println("创造中国人的Foot");
        productPerson.setFoot("创造中国人的Foot");
    }

    @Override
    public ProductPerson build() {
        System.out.println("创建完成");
        return productPerson;
    }
}
