package com.library.xiaolong.serviceimpl;

import com.library.xiaolong.Iservice.ILoginService;
import com.library.xiaolong.domian.ReaderCard;
import com.library.xiaolong.mapper.AdminMapper;
import com.library.xiaolong.mapper.ReaderCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoginService implements ILoginService{

    @Autowired
    private ReaderCardMapper readerCardMapper;
    @Autowired
    private AdminMapper adminDao;

    public boolean hasMatchReader(long readerId,String password){
        return  readerCardMapper.getIdMatchCount(readerId, password)>0;
    }

    public String getAdminUsername(long adminId) {
        return adminDao.getUsername(adminId);
    }

    public ReaderCard findReaderCardByReaderId(long readerId){
        return readerCardMapper.findReaderByReaderId(readerId);
    }

    public boolean hasMatchAdmin(long adminId,String password){
        return adminDao.getMatchCount(adminId, password) == 1;
    }

    public boolean adminRePassword(long adminId, String newPassword){
        return adminDao.resetPassword(adminId,newPassword)>0;
    }
    public String getAdminPassword(long adminId){
        return adminDao.getPassword(adminId);
    }

    public boolean readerRePassword(long readerId, String newPassword) {
        return readerCardMapper.resetPassword(readerId, newPassword) > 0;
    }

    public String getReaderPassword(long readerId) {
        return readerCardMapper.getPassword(readerId);
    }


}
