package com.nbcb.community.community.dto;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/25
 * @Description: com.nbcb.community.community.dto
 * @Version: 1.0
 */
public class GithubUser {
    private String id;
    private String name;
    private String bio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
