package com.library.xiaolong.mapper;

import com.library.xiaolong.domian.ReaderCard;
import com.library.xiaolong.domian.ReaderInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ReaderCardMapper {
    @Select("select count(*) from reader_card where reader_id = #{reader_id} and password = #{password}")
    int getIdMatchCount( @Param("reader_id") final long reader_id,@Param("password")final String password);
    @Select("select * from reader_card where reader_id = #{reader_id}")
    ReaderCard findReaderByReaderId(final long reader_id) ;
    @Update("update reader_card set password = #{password} where reader_id = #{reader_id}")
    int resetPassword(@Param("reader_id")final long reader_id, @Param("password")final String newPassword);
    @Insert("insert into reader_card values (#{reader_id}, #{username}, #{password})")
    int addReaderCard(@Param("reader_id")final long reader_id,@Param("username")final String username , @Param("password")final String password);//有问题，但是暂时空着
    @Select("select password from reader_card where reader_id = #{reader_id}")
    String getPassword(final long reader_id);
    @Delete("delete from reader_card where reader_id = #{reader_id}")
    int deleteReaderCard(final long reader_id);
}
