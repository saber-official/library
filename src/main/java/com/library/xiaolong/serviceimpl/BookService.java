package com.library.xiaolong.serviceimpl;

import com.library.xiaolong.Iservice.IBookService;
import com.library.xiaolong.domian.Book;
import com.library.xiaolong.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Transactional
@Service
public class BookService implements IBookService{
    @Autowired
    private BookMapper bookMapper;
    public ArrayList<Book> queryBook(String searchWord) {
        return bookMapper.queryBook(searchWord);
    }

    public ArrayList<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    public boolean matchBook(String searchWord) {
        return bookMapper.matchBook(searchWord) > 0;
    }

    public boolean addBook(Book book) {
        return bookMapper.addBook(book) > 0;
    }

    public Book getBook(Long bookId) {
        return bookMapper.getBook(bookId);
    }

    public boolean editBook(Book book) {
        return bookMapper.editBook(book) > 0;
    }

    public boolean deleteBook(Long bookId) {
        return bookMapper.deleteBook(bookId) > 0;
    }

}
