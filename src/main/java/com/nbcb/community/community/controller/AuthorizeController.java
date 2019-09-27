package com.nbcb.community.community.controller;

import com.nbcb.community.community.dto.AccessTokenDTO;
import com.nbcb.community.community.dto.GithubUser;
import com.nbcb.community.community.mapper.UserMapper;
import com.nbcb.community.community.model.User;
import com.nbcb.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

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

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){

        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String access_token=githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getUser(access_token);
        if (githubUser!=null){
            User user=new User();
            user.setName(githubUser.getName());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(githubUser.getId());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            Cookie cookie= new Cookie("token",token);
            response.addCookie(cookie);

            return "redirect:/";
        }else{
            return "redirect:/";
        }
    }
}
