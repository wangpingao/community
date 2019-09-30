package com.nbcb.community.community.model;

import lombok.Data;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/27
 * @Description: com.nbcb.community.community.model
 * @Version: 1.0
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;

}
