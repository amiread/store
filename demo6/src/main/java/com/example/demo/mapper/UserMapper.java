package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author admin
 * @create 2022-12-04 20:31
 */
public interface UserMapper {

        Integer insert(User user);
        User findByUsername(String username);
        Integer updatePasswordByuid(@Param("uid") Integer uid,
                                    @Param("password") String password,
                                    @Param("modifiedUser") String modifiedUser,
                                    @Param("modifiedTime") Date modifiedTime);
        User findByuid(Integer uid);

        Integer updateInfoByUid(User user);
}
