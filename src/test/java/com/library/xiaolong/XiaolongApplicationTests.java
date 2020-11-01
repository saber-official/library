package com.library.xiaolong;

import com.library.xiaolong.domian.Admin;
import com.library.xiaolong.domian.Book;
import com.library.xiaolong.domian.Lend;
import com.library.xiaolong.domian.ReaderInfo;
import com.library.xiaolong.mapper.AdminMapper;
import com.library.xiaolong.mapper.BookMapper;
import com.library.xiaolong.mapper.LendMapper;
import com.library.xiaolong.mapper.ReaderInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * BookMapper
 * int i = bm.addBook(new Book(110, "何以笙箫默", "顾漫 sdf 的身份", "朝华出版社", "9787505414709", "一段年少时的爱恋，牵出一生的纠缠。大学时代的赵默笙阳光灿烂，对法学系大才子何以琛一见倾心，开朗直率的她拔足倒追，终于使才气出众的他为她停留驻足。然而，不善表达的他终于使她在一次伤心之下远走他乡……", "中文", new BigDecimal("15.00"), new Date("2019/11/07"), 7, 0));
 * addbook->ok
 * editbook->ok
 * querybook->ok
 * getbook->ok
 * matchBook->ok
 * deleteBook->ok
 * queryall->ok
 */

/***
 * AdmianMapper
 * getMatchCount->ok
 * resetPassword->ok
 * getPassword->ok
 * getUsername->ok
 */

/**
 * LendMapper
 * lendList->ok
 * myLendList->ok
 * returnBookOne->ok
 * returnBookTwo->ok
 * lendBookOne->ok
 * lendBookTwo->ok
 * deleteLend->ok
 *
 */
@SpringBootTest
class XiaolongApplicationTests {
	@Autowired
	ReaderInfoMapper lm;
	@Test
	void contextLoads() {
		long l = lm.addReaderInfo(new ReaderInfo("swa", "sd", new Date("2020/1/1"), "zsz", "zssz"));
		System.out.println(l);
	}
}
