package com.njupt.protostuff.Entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wall
 * @date 2018/11/27  21:51
 * @description Lombok能以简单的注解形式来简化java代码，提高开发人员的开发效率。
 * *@Data注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，
 * 如为final属性，则不会为该属性生成setter方法。
 * *@Builder注解可以让我们通过更加优雅的构建者模式来创建对象。
 */
@Data
@Builder
public class User {
    private String id;

    private String name;

    private Integer age;

    private String desc;
}
