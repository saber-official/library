package com.library.xiaolong.mapper;

import com.library.xiaolong.domian.Book;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
@Mapper
public interface BookMapper {
    @Select("select count(name) from book_info where name like CONCAT(#{search},'%') or author like CONCAT(#{search},'%') or introduction like CONCAT(#{search},'%')")
    int matchBook(final String searchWord);
    @Select("select * from book_info where name like CONCAT(#{search},'%') or author like CONCAT(#{search},'%') or introduction like CONCAT(#{search},'%')")
    ArrayList<Book> queryBook(final String searchWord);
    @Select("select * from book_info")
    ArrayList<Book> getAllBooks();
    @Insert("insert into book_info values (null, #{name}, #{author}, #{publish}, #{ISBN}, #{introduction}, #{language}, #{price}, #{pub_date}, #{class_id}, #{number})")
    int addBook(final Book book);
    @Select("select * from book_info where book_id = #{book_id}")
    Book getBook(final long bookId);
    @Update("update book_info set name=#{name}, author=#{author},\n" +
            " publish=#{publish}, ISBN=#{ISBN}, introduction=#{introduction},\n" +
            " language=#{language}, price=#{price}, pub_date=#{pub_date},\n" +
            " class_id=#{class_id}, number=#{number} where book_id=#{book_id}")
    int editBook(final Book book);
    @Delete("delete from book_info where book_id = #{book_id}")
    int deleteBook(final long bookId);
}
