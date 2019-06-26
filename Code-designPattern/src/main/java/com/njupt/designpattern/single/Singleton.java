package com.njupt.designpattern.single;

/**
 * @author wall
 * @date 2019/6/25  16:48
 * @description 静态内部类实现的单例模式
 */
public class Singleton {
    //1.构造方法的私有化
    private Singleton(){}

    //2.编写一个静态内部类，当加载外部类时不会立即加载内部类，延迟了单例的实例化
    private static class SingletonHoler{
        //3.instance为类变量，会调用类构造器<clinit>进行初始化，<clinit>方法在多线程环境中被正确地加锁、同步
        private static Singleton instance = new Singleton();
    }

    private static Singleton getInstance(){
        return SingletonHoler.instance;
    }
}
