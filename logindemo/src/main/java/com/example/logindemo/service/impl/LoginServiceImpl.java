/**
 * @projectName logindemo
 * @package com.example.logindemo.service.impl
 * @className com.example.logindemo.service.impl.LoginServiceImpl
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.service.impl;


import com.example.logindemo.mapper.ILoginMapper;
import com.example.logindemo.service.ILoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginServiceImpl
 * @description
 * @author lichengyong
 * @date 2020/12/25 10:10
 * @version 1.0
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private ILoginMapper loginMapper;

    @Override
    public String login(String username, String password) {
        return loginMapper.login(username,password);
    }
}