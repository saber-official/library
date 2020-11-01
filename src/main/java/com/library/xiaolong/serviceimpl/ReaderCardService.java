package com.library.xiaolong.serviceimpl;


import com.library.xiaolong.Iservice.IReaderCardService;
import com.library.xiaolong.domian.ReaderInfo;
import com.library.xiaolong.mapper.ReaderCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ReaderCardService implements IReaderCardService{
    @Autowired
    private ReaderCardMapper readerCardMapper;

    public boolean addReaderCard(ReaderInfo readerInfo, String password){
        return  readerCardMapper.addReaderCard(readerInfo.getReaderId(),readerInfo.getName(),password)>0;
    }
    public boolean updatePassword(long readerId, String password){
        return readerCardMapper.resetPassword(readerId,password)>0;
    }

    public boolean deleteReaderCard(long readerId) {
        return readerCardMapper.deleteReaderCard(readerId) > 0;
    }
}
