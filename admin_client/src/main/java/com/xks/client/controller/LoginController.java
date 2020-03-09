package com.xks.client.controller;

import com.xks.client.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public String login() {
        logger.info("进入login");
        return "/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public void login(String username, String password) {
        // 密码MD5加密
        //password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            logger.info("ok");
        } catch (UnknownAccountException e) {
            logger.info(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            logger.info(e.getMessage());
        } catch (LockedAccountException e) {
            logger.info(e.getMessage());
        } catch (AuthenticationException e) {
            logger.info("认证失败！");
        }
    }

//    @RequestMapping("/")
//    public String redirectIndex() {
//        return "redirect:/login";
//    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}