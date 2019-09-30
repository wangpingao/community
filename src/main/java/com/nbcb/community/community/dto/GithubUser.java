package com.nbcb.community.community.dto;

import lombok.Data;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/25
 * @Description: com.nbcb.community.community.dto
 * @Version: 1.0
 */
@Data
public class GithubUser {
    private String id;
    private String name;
    private String bio;
    private String avatar_url;
}
