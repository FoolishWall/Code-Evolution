package com.njupt.protostuff;

import com.njupt.protostuff.Entity.Group;
import com.njupt.protostuff.Entity.User;
import com.njupt.protostuff.Utils.ProtostuffUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CodeProtostuffApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CodeProtostuffApplication.class, args);
    }

    @Override
    public void run(String... strings)  {
        //创建一个user对象
        User user = User.builder().id("1").age(20).name("张三").desc("programmer").build();
        //创建一个Group对象
        Group group = Group.builder().id("1").name("分组1").user(user).build();
        //使用ProtostuffUtils序列化
        byte[] data = ProtostuffUtils.serialize(group);
        System.out.println("序列化后：" + Arrays.toString(data));
        Group result = ProtostuffUtils.deserialize(data, Group.class);
        System.out.println("反序列化后：" + result.toString());
    }
}
