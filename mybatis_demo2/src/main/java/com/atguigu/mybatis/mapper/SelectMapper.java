package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    User getUserById( Integer id);

    Integer getCount();

    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);


    //    List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();

    @MapKey("id")
    Map<String, Object> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    void insertUser(User user);
}
