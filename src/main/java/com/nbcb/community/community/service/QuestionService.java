package com.nbcb.community.community.service;

import com.nbcb.community.community.dto.PaginationDTO;
import com.nbcb.community.community.dto.QuestionDTO;
import com.nbcb.community.community.mapper.QuestionMapper;
import com.nbcb.community.community.mapper.UserMapper;
import com.nbcb.community.community.model.Question;
import com.nbcb.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/29
 * @Description: com.nbcb.community.community.service
 * @Version: 1.0
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;


    public PaginationDTO list(Integer page, Integer size) {
        Integer totalCount=questionMapper.selCount();
        Integer totalPage;
        if (totalCount%size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }
        if (page<=0){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        PaginationDTO paginationDTO=new PaginationDTO();
        paginationDTO.setPagination(totalCount,page,size);

        Integer offset=size*(paginationDTO.getPage()-1);
        List<Question> questionList=questionMapper.selPagination(offset,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question:questionList) {
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            User user=userMapper.selById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOList(questionDTOList);
        return paginationDTO;
    }
}
