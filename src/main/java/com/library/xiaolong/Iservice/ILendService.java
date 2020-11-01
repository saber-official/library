package com.library.xiaolong.Iservice;

import com.library.xiaolong.domian.Lend;

import java.util.ArrayList;

public interface ILendService {
    boolean returnBook(long bookId, long readerId);
    boolean lendBook(long bookId,long readerId);
    ArrayList<Lend> lendList();
    ArrayList<Lend> myLendList(long readerId);
    int deleteLend(long serNum);
}
