package com.nbcb.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/24
 * @Description: com.nbcb.community.community.controller
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        return "index";
    }
}
