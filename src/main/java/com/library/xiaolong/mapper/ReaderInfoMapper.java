package com.library.xiaolong.mapper;

import com.library.xiaolong.domian.ReaderInfo;
import org.apache.ibatis.annotations.*;
import java.util.ArrayList;

@Mapper
public interface ReaderInfoMapper {
    @Select("select * from reader_info")
     ArrayList<ReaderInfo> getAllReaderInfo();
    @Select("select * from reader_info where reader_id = #{reader_id}")
     ReaderInfo findReaderInfoByReaderId(final long reader_id) ;
    @Delete("delete from reader_info where reader_id = #{reader_id}")
     int deleteReaderInfo(final long reader_id) ;
    @Update("update reader_info set name = #{name} , sex = #{sex}, birth = #{birth} ,address = #{address} ,phone = #{phone}  where reader_id = #{reader_id}")
     int editReaderInfo(final ReaderInfo readerInfo) ;
    @Update("update reader_card set username = #{name} where reader_id = #{reader_id}")
     int editReaderCard(final ReaderInfo readerInfo) ;
//    @Insert("insert into reader_info values (null, #{name},#{sex},#{birth},#{address},#{phone})")
//    long addReaderInfo(final ReaderInfo readerInfo);//待修改
//    {
//        if (sqlSessionTemplate.insert(NAMESPACE + "addReaderInfo", readerInfo) > 0) {
//            return sqlSessionTemplate.selectOne(NAMESPACE + "getReaderId", readerInfo);
//        } else {
//            return -1;
//        }
//    }
    default long addReaderInfo(ReaderInfo readerInfo){
        if (addReaderInfoOne(readerInfo)>0){
            return getReaderInfo(readerInfo);
        }else {
            return -1;
        }
    }
    @Select("select reader_id from reader_info where name = #{name} and sex = #{sex} and birth = #{birth} and address = #{address} and phone = #{phone}")
    long getReaderInfo(ReaderInfo readerInfo);
    @Insert("insert into reader_info values (null, #{name},#{sex},#{birth},#{address},#{phone})")
    int addReaderInfoOne(ReaderInfo readerInfo);
}
