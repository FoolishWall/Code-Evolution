package com.njupt.springcode.springmybatis;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wall
 * @date 2019/7/4  16:58
 * @description
 */

public interface StudentDao {
    @Select("select * form person")
    List<Person> showAll();
}
