package com.library.xiaolong.serviceimpl;

import com.library.xiaolong.Iservice.IReaderInfoService;
import com.library.xiaolong.domian.ReaderInfo;
import com.library.xiaolong.mapper.ReaderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional
@Service
public class ReaderInfoService implements IReaderInfoService{
    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    public ArrayList<ReaderInfo> readerInfos() {
        return readerInfoMapper.getAllReaderInfo();
    }

    public boolean deleteReaderInfo(long readerId) {
        return readerInfoMapper.deleteReaderInfo(readerId) > 0;
    }

    public ReaderInfo getReaderInfo(long readerId) {
        return readerInfoMapper.findReaderInfoByReaderId(readerId);
    }

    public boolean editReaderInfo(ReaderInfo readerInfo) {
        return readerInfoMapper.editReaderInfo(readerInfo) > 0;
    }

    public boolean editReaderCard(ReaderInfo readerInfo) {
        return readerInfoMapper.editReaderCard(readerInfo) > 0;
    }

    public long addReaderInfo(ReaderInfo readerInfo) {
        return readerInfoMapper.addReaderInfo(readerInfo);
    }
}
