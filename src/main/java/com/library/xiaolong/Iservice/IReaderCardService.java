package com.library.xiaolong.Iservice;

import com.library.xiaolong.domian.ReaderInfo;

public interface IReaderCardService {
    boolean addReaderCard(ReaderInfo readerInfo, String password);
    boolean updatePassword(long readerId, String password);
    boolean deleteReaderCard(long readerId);
}
