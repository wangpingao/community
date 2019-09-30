package com.nbcb.community.community.model;

import lombok.Data;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/27
 * @Description: com.nbcb.community.community.model
 * @Version: 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;

}
