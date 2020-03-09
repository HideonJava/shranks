package com.xks.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/email")
public class EmailController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //@Autowired
    private JavaMailSender jms;

    //@Value("${spring.mail.username}")
    private String from;

    //@RequestMapping(value = "sendSimpleEmail",method = RequestMethod.GET)
    public String sendSimpleEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("2962824136@qq.com"); // 接收地址
            message.setSubject("我爱宋雨琴"); // 标题
            message.setText("个憨批。"); // 内容
            LOGGER.info("发送成功");
            jms.send(message);
            return "发送成功";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
