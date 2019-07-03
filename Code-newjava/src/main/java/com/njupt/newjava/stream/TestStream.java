package com.njupt.newjava.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author wall
 * @date 2019/7/1  9:53
 * @description 测试stream
 *
 * 它没有内部存储，它只是用操作管道从source（数据结构、数组、generator function、IO channel）抓取数据
 * 它也绝不修改自己所封装的底层数据结构的数据。例如Stream的filter操作会产生一个不包含被过滤元素的新Stream，而不是从source删除那些元素
 *
 * Stream的并行操作依赖于Java7中引入的Fork/Join框架（JSR166y）来拆分任务和加速处理过程。
 */
public class TestStream {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ec");
        list.add("bc");
        list.add("bc");
        list.add("ac");
        list.add("ac");
        list.add("ac");

        ArrayList<Integer> listInteger = new ArrayList<>();
        listInteger.add(3);
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(1);
        listInteger.add(2);

        //使用stream对list进行排序去重
//        list.stream().sorted(String::compareTo).distinct().forEach(System.out::println);

        //取平方数,并排序
//        listInteger.stream().map(n->n*n).sorted(Integer::compareTo).distinct().forEach(System.out::println);

        //取平方数，并取最大值或是最小值
//        System.out.println(listInteger.stream().map(n->n*n).reduce(Integer.MAX_VALUE,Integer::min));
//        System.out.println(listInteger.stream().map(n->n*n).reduce(Integer.MIN_VALUE,Integer::max));

        //limit/skip
        //limit返回Stream的前面n个元素；skip则是扔掉前n个元素（它是由一个叫subStream的方法改名而来）。
//        list.stream().sorted(String::compareTo).limit(2).skip(1).forEach(System.out::println);

        //生成一个等差数列
        Stream.iterate(0,n->n+3).limit(5).forEach(System.out::println);
    }
}
