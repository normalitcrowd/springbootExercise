/**
 * @projectName logindemo
 * @package com.example.logindemo.controller
 * @className com.example.logindemo.controller.LoginController
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.example.logindemo.controller;

import com.example.logindemo.service.ILoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * LoginController
 * @description
 * @date 2020/12/25 9:57
 * @version 1.0
 */
@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;

//    private static final String SUCCESS = "success";

    /**
     * 输入localhost:端口号后就会跳到login页面
     * @return
     */
    @RequestMapping("login")
    public String goLogin(){
        return "login";
    }

    /**
     *登录用POST
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpSession session, Map<String,Object> map){
        //request.getParameter通过submit按钮触发，根据名称从表单拿数据[也可以@RequestParam("username") String username直接传过来]
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = loginService.login(username,password);
        //session.setAttribute把后端值赋给前端页面
        session.setAttribute("nickname",nickname);
        if(StringUtils.isNotEmpty(nickname)){
            session.setAttribute("userName",username);
            return "redirect:/main";
        }else{
            //密码错误时，清空session，提示信息放到map里
            session.invalidate();
            map.put("msg","用户名密码错误！");
            //进行重定向，redirect后面跟的是什么，就返回到哪一个requestmapping的value值
            return "login";
        }
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();  //防止浏览器返回按钮，不行，还是要写js
        return "login";
    }

    /**
     * 进入主页
     * @return
     */
    @RequestMapping("main")
    public String goMain(){
        return "main";
    }

    /**
     * 进入其他页面————验证拦截器
     * @returnPost
     */
    @RequestMapping("other")
    public String goOther(){
        return "other";
    }


}