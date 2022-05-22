package com.xuyuchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-22:05
 * @Description:
 */
@Controller
public class LoginController {
    /**
     * 用户登录
     * @param username
     * @param password
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        if("admin".equals(username) && "admin".equals(password)) {
            //将登陆信息存入session
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            //登陆成功重定向主页面
            return "redirect:/main.html";
        }
        model.addAttribute("msg","用户名或密码错误!");
        //回到登陆界面
        return "index";
    }

    /**
     * 用户注销
     * @return
     */
    @RequestMapping("/user/loginOut")
    public String loginOut(HttpSession session) {
        //清空session
        session.invalidate();
        return "redirect:/index";
    }
}
