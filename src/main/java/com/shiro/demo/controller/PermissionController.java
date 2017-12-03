package com.shiro.demo.controller;

import com.shiro.demo.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@Controller
public class PermissionController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit() {
        return "edit";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }

    @RequestMapping("/loginuser")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            HttpSession session) {
        //拼装UsernamePasswordToken对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //得到主体
        Subject subject = SecurityUtils.getSubject();
        try {
            //调用login方法，该方法会调用到我们设置的security方法
            subject.login(usernamePasswordToken);
            //得到认证的信息
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

}
