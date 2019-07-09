package com.njupt.springcode.springmybatis;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @author wall
 * @date 2019/7/4  20:23
 * @description
 */
public class Start {
    public static void main(String[] args) {
        //模拟mybatis
        Class [] classes = new Class[]{StudentDao.class};
        /**
         * 1.类加载器
         * 2.接口
         * 3.实现InvocationHandler的实现类
         */
        StudentDao studentDao = (StudentDao) Proxy.newProxyInstance(Start.class.getClassLoader(),
                classes,new MybatisHandler());
        studentDao.showAll();
    }
}
