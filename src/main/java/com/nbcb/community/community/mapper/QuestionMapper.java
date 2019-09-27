package com.nbcb.community.community.mapper;

import com.nbcb.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/27
 * @Description: com.nbcb.community.community.mapper
 * @Version: 1.0
 */
@Mapper
@Repository
public interface QuestionMapper {

    @Insert("insert into question(title,description,tag,gmt_create,gmt_modified,creator) values(#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{creator})")
    void insert(Question question);

}
