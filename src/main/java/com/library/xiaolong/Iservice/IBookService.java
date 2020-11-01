package com.library.xiaolong.Iservice;

import com.library.xiaolong.domian.Book;

import java.util.ArrayList;

public interface IBookService {
    ArrayList<Book> queryBook(String searchWord);
    ArrayList<Book> getAllBooks();
    boolean matchBook(String searchWord);
    boolean addBook(Book book);
    Book getBook(Long bookId);
    boolean editBook(Book book);
    boolean deleteBook(Long bookId);
}
