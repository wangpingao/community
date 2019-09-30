package com.nbcb.community.community.mapper;

import com.nbcb.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Select("select * from question")
    List<Question> selAll();

    @Select("select * from question limit #{offset},#{size}")
    List<Question> selPagination(@Param("offset") Integer offset,@Param("size") Integer size);
    @Select("select count(1) from question")
    Integer selCount();
}
