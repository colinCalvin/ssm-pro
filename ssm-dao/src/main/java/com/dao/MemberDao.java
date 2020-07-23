package com.dao;

import com.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Description: Member的dao层接口
 */
@Repository
public interface MemberDao {

    /**
     * @Description 根据会员id查询会员信息
     * @Param [memberId]
     * @return com.domain.Member
     **/
    @Select("SELECT * FROM member WHERE id = #{id}")
    Member findById(String id);
}
