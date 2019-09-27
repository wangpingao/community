package com.nbcb.community.community.mapper;

import com.nbcb.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/27
 * @Description: com.nbcb.community.community.mapper
 * @Version: 1.0
 */
@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);
}
