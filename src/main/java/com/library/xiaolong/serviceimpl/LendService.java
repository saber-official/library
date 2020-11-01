package com.library.xiaolong.serviceimpl;

import com.library.xiaolong.Iservice.ILendService;
import com.library.xiaolong.domian.Lend;
import com.library.xiaolong.mapper.LendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional
@Service
public class LendService implements ILendService{
    @Autowired
    private LendMapper lendMapper;

    public boolean returnBook(long bookId, long readerId){
        return lendMapper.returnBookOne(bookId, readerId)>0 && lendMapper.returnBookTwo(bookId)>0;
    }

    public boolean lendBook(long bookId,long readerId){
        return lendMapper.lendBookOne(bookId,readerId)>0 && lendMapper.lendBookTwo(bookId)>0;
    }

    public ArrayList<Lend> lendList(){
        return lendMapper.lendList();
    }
    public ArrayList<Lend> myLendList(long readerId){
        return lendMapper.myLendList(readerId);
    }

    public int deleteLend(long serNum) {
        return lendMapper.deleteLend(serNum);
    }

}
