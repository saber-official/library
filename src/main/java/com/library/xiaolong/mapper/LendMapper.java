package com.library.xiaolong.mapper;

import com.library.xiaolong.domian.Lend;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
@Mapper
public interface LendMapper {
    @Update("update lend_list set back_date = sysdate() where book_id = #{book_id} and reader_id = #{reader_id} and back_date is null")
    int returnBookOne(@Param("book_id") final long book_id,@Param("reader_id") long reader_id) ;
    @Update("update book_info set number = number + 1 where book_id = #{book_id}")
    int returnBookTwo(final long book_id);
    @Insert("insert into lend_list values (null , #{book_id} , #{reader_id} , sysdate() , null)")
    int lendBookOne(@Param("book_id") final long book_id,@Param("reader_id") final long reader_id) ;
    @Update("update book_info set number = number - 1 where book_id = #{book_id}")
    int lendBookTwo(final long book_id) ;
    @Select("select * from lend_list")
    ArrayList<Lend> lendList();
    @Select("select * from lend_list where reader_id = #{reader_id}")
    ArrayList<Lend> myLendList(final long reader_id) ;
    @Delete("delete from lend_list where ser_num = #{ser_num}")
    int deleteLend(final long ser_num) ;
}
