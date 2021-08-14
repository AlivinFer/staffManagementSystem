package com.alivin.staffmanagementsystem.controller;

import com.alivin.staffmanagementsystem.service.api.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class LoginController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            // 告知用户登录失败
            model.addAttribute("msg", "用户或密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/loginout")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

}
