package com.skytech.grading.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ViewController
 * @Description TODO
 * @Date 2019/4/29 22:47
 * @Created by huangdasheng
 */
@Controller
public class ViewController {

    /**
     * 登录
     * @return
     */
    /*@GetMapping("/")
    public String index() {
        return "login";
    }*/

    /**
     * 欢迎页
     * @return
     */
    /*@GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }*/

    @RequestMapping("/")
    public String toIndex() {
        return "login";
    }
}
