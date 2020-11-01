package com.library.xiaolong.controller;

import com.library.xiaolong.domian.Book;
import com.library.xiaolong.domian.Lend;
import com.library.xiaolong.domian.ReaderCard;
import com.library.xiaolong.serviceimpl.BookService;
import com.library.xiaolong.serviceimpl.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private LendService lendService;

    private Date getDate(String pubstr) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(pubstr);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    @RequestMapping("/querybook.html")
    public String queryBookDo(String searchWord, Model model) {
        if (bookService.matchBook(searchWord)) {
            ArrayList<Book> books = bookService.queryBook(searchWord);
            model.addAttribute("books", books);
            return "admin_books";
        } else {
            model.addAttribute("error", "没有匹配的图书");
            return "admin_books";
        }
    }

    @RequestMapping("/reader_querybook_do.html")
    public String readerQueryBookDo(String searchWord,Model model) {
        if (bookService.matchBook(searchWord)) {
            ArrayList<Book> books = bookService.queryBook(searchWord);
            model.addAttribute("books", books);
            return "reader_books";
        } else {
            model.addAttribute("error", "没有匹配的图书");
            return "reader_books";
        }
    }

    @RequestMapping("/admin_books.html")
    public String adminBooks(Model model) {
        ArrayList<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "admin_books";
    }

    @RequestMapping("/book_add.html")
    public String addBook() {
        return "admin_book_add";
    }

    @RequestMapping("/book_add_do.html")
    public String addBookDo(@RequestParam(value = "pubstr") String pubstr, Book book, RedirectAttributes redirectAttributes) {
        book.setPubdate(getDate(pubstr));
        if (bookService.addBook(book)) {
            redirectAttributes.addFlashAttribute("succ", "图书添加成功！");
        } else {
            redirectAttributes.addFlashAttribute("succ", "图书添加失败！");
        }
        return "redirect:/admin_books.html";
    }

    @RequestMapping("/updatebook.html")
    public String bookEdit(HttpServletRequest request,Model model) {
        long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "admin_book_edit";
    }

    @RequestMapping("/book_edit_do.html")
    public String bookEditDo(@RequestParam(value = "pubstr") String pubstr, Book book, RedirectAttributes redirectAttributes) {
        book.setPubdate(getDate(pubstr));
        if (bookService.editBook(book)) {
            redirectAttributes.addFlashAttribute("succ", "图书修改成功！");
        } else {
            redirectAttributes.addFlashAttribute("error", "图书修改失败！");
        }
        return "redirect:/admin_books.html";
    }

    @RequestMapping("/admin_book_detail.html")
    public String adminBookDetail(HttpServletRequest request,Model model) {
        long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "admin_book_detail";
    }

    @RequestMapping("/reader_book_detail.html")
    public String readerBookDetail(HttpServletRequest request,Model model) {
        long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bookService.getBook(bookId);
        model.addAttribute("detail", book);
        return "reader_book_detail";
    }

    @RequestMapping("/admin_header.html")
    public String admin_header() {
        return "admin_header";
    }

    @RequestMapping("/reader_header.html")
    public String reader_header() {
        return "reader_header";
    }

    @RequestMapping("/reader_books.html")
    public String readerBooks(HttpServletRequest request,Model model) {
        ArrayList<Book> books = bookService.getAllBooks();
        ReaderCard readerCard = (ReaderCard) request.getSession().getAttribute("reader");
        ArrayList<Lend> myAllLendList = lendService.myLendList(readerCard.getReaderId());

        ArrayList<Long> myLendList = new ArrayList<>();
        for (Lend lend : myAllLendList) {
            // 是否已归还
            if (lend.getBackDate() == null) {
                myLendList.add(lend.getBookId());
            }
        }
        model.addAttribute("books", books);
        model.addAttribute("myLendList", myLendList);
        return "reader_books";
    }
}
