package com.njupt.mybatisintercept.dao;


import com.njupt.mybatisintercept.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {
    /**
     * 查询
     * @param userEntity
     * @return
     */
    List<UserEntity> selectUser(UserEntity userEntity);

}
