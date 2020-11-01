package com.library.xiaolong.Iservice;

import com.library.xiaolong.domian.ReaderInfo;

import java.util.ArrayList;

public interface IReaderInfoService {
    ArrayList<ReaderInfo> readerInfos();
    boolean deleteReaderInfo(long readerId);
    ReaderInfo getReaderInfo(long readerId);
    boolean editReaderInfo(ReaderInfo readerInfo);
    boolean editReaderCard(ReaderInfo readerInfo);
    long addReaderInfo(ReaderInfo readerInfo);

}
