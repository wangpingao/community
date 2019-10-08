package com.nbcb.community.community.advice;

import com.nbcb.community.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: wangpingao
 * @Date: 2019/10/8
 * @Description: com.nbcb.community.community.advice
 * @Version: 1.0
 */
@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e, Model model) {
        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else{
            model.addAttribute("message","服务太热了，要不您稍后再试试");
        }

        return new ModelAndView("error");
    }
}
