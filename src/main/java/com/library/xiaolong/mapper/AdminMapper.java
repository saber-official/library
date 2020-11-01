package com.library.xiaolong.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface AdminMapper {
    @Select("select count(*) from admin where admin_id = #{admin_id} and password = #{password}")
    int getMatchCount(@Param("admin_id") final long admin_id,@Param("password")  final String password) ;
    @Update("update admin set password = #{password} where admin_id = #{admin_id}")
    int resetPassword(@Param("admin_id") final long admin_id, @Param("password") final String password) ;
    @Select("select password from admin where admin_id = #{admin_id}")
    String getPassword(final long admin_id) ;
    @Select("select username from admin where admin_id = #{admin_id}")
    String getUsername(final long admin_id);
}
