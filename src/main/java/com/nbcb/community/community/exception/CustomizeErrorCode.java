package com.nbcb.community.community.exception;

/**
 * @Auther: wangpingao
 * @Date: 2019/10/8
 * @Description: com.nbcb.community.community.exception
 * @Version: 1.0
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("问题不存在，请换一个试试");

    private String message;
    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message){
        this.message=message;
    }
}
