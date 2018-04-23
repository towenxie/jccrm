package com.xe.b2b.data.access.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.xe.b2b.data.access.dao.base.BaseMapper;
import com.xe.b2b.data.access.model.RoleEntity;

public interface RoleDao extends BaseMapper<RoleEntity> {
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table tbl_role
//     *
//     * @mbggenerated
//     */
//    @Delete({
//        "delete from tbl_role",
//        "where id = #{id,jdbcType=VARCHAR}"
//    })
//    int deleteByPrimaryKey(String id);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table tbl_role
//     *
//     * @mbggenerated
//     */
//    @Insert({
//        "insert into tbl_role (id, name, ",
//        "remark, status, ",
//        "creater, create_time)",
//        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
//        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
//        "#{creater,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
//    })
//    int insert(RoleEntity record);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table tbl_role
//     *
//     * @mbggenerated
//     */
//    int insertSelective(RoleEntity record);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table tbl_role
//     *
//     * @mbggenerated
//     */
//    @Select({
//        "select",
//        "id, name, remark, status, creater, create_time",
//        "from tbl_role",
//        "where id = #{id,jdbcType=VARCHAR}"
//    })
//    @ResultMap("PagingResultMap")
//    RoleEntity selectByPrimaryKey(String id);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table tbl_role
//     *
//     * @mbggenerated
//     */
//    int updateByPrimaryKeySelective(RoleEntity record);
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method corresponds to the database table tbl_role
//     *
//     * @mbggenerated
//     */
//    @Update({
//        "update tbl_role",
//        "set name = #{name,jdbcType=VARCHAR},",
//          "remark = #{remark,jdbcType=VARCHAR},",
//          "status = #{status,jdbcType=INTEGER},",
//          "creater = #{creater,jdbcType=VARCHAR},",
//          "create_time = #{createTime,jdbcType=TIMESTAMP}",
//        "where id = #{id,jdbcType=VARCHAR}"
//    })
//    int updateByPrimaryKey(RoleEntity record);
//    
//    
//    
	
    @Select({
        "select * from b2b_role where code in(select role_code from b2b_user_role where WORK_ID=#{workId} AND is_active = 1)"
    })
    @ResultMap("baseRoleMap")
    List<RoleEntity> selectByUser(String workId);
    
    List<RoleEntity> selectAll();

}