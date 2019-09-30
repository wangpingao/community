package com.nbcb.community.community.dto;

import com.nbcb.community.community.model.User;
import lombok.Data;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/29
 * @Description: com.nbcb.community.community.dto
 * @Version: 1.0
 */
@Data
public class QuestionDTO {
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
    private User user;
}
