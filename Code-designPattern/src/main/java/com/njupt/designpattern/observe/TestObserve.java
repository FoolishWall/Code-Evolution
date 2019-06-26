package com.njupt.designpattern.observe;


/**
 * @author wall
 * @date 2019/6/25  20:47
 * @description
 */
public class TestObserve {
    public static void main(String[] args) {
        SubjectExtend subjectExtend = new SubjectExtend();
        //注册观察者
        subjectExtend.register(new Observer1());
        subjectExtend.register(new Observer2());

        subjectExtend.run();
    }

}
