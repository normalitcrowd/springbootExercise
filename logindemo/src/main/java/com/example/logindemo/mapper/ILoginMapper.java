/**
 * @projectName logindemo
 * @package com.example.logindemo.mapper
 * @className com.example.logindemo.mapper.ILoginMapper
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.mapper;

import com.example.logindemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ILoginMapper
 * @description
 * @author lichengyong
 * @date 2020/12/25 10:09
 * @version 1.0
 */
@Repository
public interface ILoginMapper {
    String login(@Param("username")String username, @Param("password")String password);
}