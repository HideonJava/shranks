package com.xks.client.controller;

import com.xks.client.entity.User;
import com.xks.client.interf.PassToken;
import com.xks.client.interf.UserLoginToken;
import com.xks.client.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @PassToken
    @GetMapping("/login")
    public String login() {
        logger.info("进入login");
        return "/login";
    }

    @PostMapping("/login")
    //@ResponseBody
    public Object login(String username, String password) {
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUserName(username);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(userForBase.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = userForBase.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/login";
    }

    @UserLoginToken
    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
//        User user = (User) SecurityUtils.getSubject().getPrincipal();
//        model.addAttribute("user", user);
        return "/index";
    }
}