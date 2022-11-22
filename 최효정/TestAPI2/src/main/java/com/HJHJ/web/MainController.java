package com.HJHJ.web;

import com.HJHJ.domain.Book;
import com.HJHJ.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private BookService bookService;

    @GetMapping("/book")
    public List<Book> getBookList() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.findOne(id);
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
}

