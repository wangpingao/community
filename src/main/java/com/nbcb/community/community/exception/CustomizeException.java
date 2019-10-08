package com.nbcb.community.community.exception;

/**
 * @Auther: wangpingao
 * @Date: 2019/10/8
 * @Description: com.nbcb.community.community.exception
 * @Version: 1.0
 */
public class CustomizeException extends RuntimeException {
    private String message;
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message=errorCode.getMessage();
    }
    public CustomizeException(String message){
        this.message=message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
