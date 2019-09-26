package com.nbcb.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.nbcb.community.community.dto.AccessTokenDTO;
import com.nbcb.community.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/25
 * @Description: com.nbcb.community.community.provider
 * @Version: 1.0
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String url="https://github.com/login/oauth/access_token";
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();
            String[] split = string.split("&");
            String[] access_token=split[0].split("=");
            return access_token[1];
        } catch (IOException e) {

        }

        return null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        String url="https://api.github.com/user?access_token="+accessToken;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();
            GithubUser githubUser= JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (IOException e) {

        }
        return null;
    }

}
