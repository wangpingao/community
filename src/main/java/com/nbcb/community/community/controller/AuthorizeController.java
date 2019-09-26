package com.nbcb.community.community.controller;

import com.nbcb.community.community.dto.AccessTokenDTO;
import com.nbcb.community.community.dto.GithubUser;
import com.nbcb.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/25
 * @Description: com.nbcb.community.community.controller
 * @Version: 1.0
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id("4258d63e07a94fad0639");
        accessTokenDTO.setClient_secret("81e9b753e8db343c68248d222bc2ab5c958a9e0a");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        String access_token=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getUser(access_token);
        System.out.println(githubUser.getName());
        return "index";
    }
}
