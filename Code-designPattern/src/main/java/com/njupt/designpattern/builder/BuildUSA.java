package com.njupt.designpattern.builder;

/**
 * @author wall
 * @date 2019/7/9  20:09
 * @description 具体建造者
 */
public class BuildUSA implements Builder {
    ProductPerson productPerson = new ProductPerson();
    @Override
    public void buildHead() {
        System.out.println("创建美国人的Head");
        productPerson.setHead("创建美国人的Head");
    }

    @Override
    public void buildBody() {
        System.out.println("创建美国人的Body");
        productPerson.setBody("创建美国人的Body");
    }

    @Override
    public void buildFoot() {
        System.out.println("创建美国人的Foot");
        productPerson.setFoot("创建美国人的Foot");
    }

    @Override
    public ProductPerson build() {
        System.out.println("创建完成");
        return productPerson;
    }
}
