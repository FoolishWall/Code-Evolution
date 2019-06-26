package com.njupt.designpattern.single;

/**
 * @author wall
 * @date 2019/6/25  16:57
 * @description DCL实现的单例模式
 */
public class DCLSingleton {
    //1.构造方法的私有化
    private DCLSingleton(){}

    //2.延迟加载单例实例，static修饰，确保为类变量
    private static DCLSingleton instance = null;

    //3.第一次加载时才初始化实例
    public static DCLSingleton getInstance(){
        //懒汉模式，如果多线程同时创建，存在线程安全
//        if (instance == null){
//            instance = new DCLSingleton();
//        }
        //4.进行双重检测，但创建实例时进行加锁
        if (instance == null){
            synchronized (DCLSingleton.class){
                if (instance == null){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
