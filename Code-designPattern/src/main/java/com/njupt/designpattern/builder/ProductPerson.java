package com.njupt.designpattern.builder;

/**
 * @author wall
 * @date 2019/7/9  20:04
 * @description 产品
 */
public class ProductPerson {
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "ProductPerson{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}
