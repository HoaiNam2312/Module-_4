package com.codegym.libraryapp.controller;

import com.codegym.libraryapp.model.Book;
import com.codegym.libraryapp.model.Reader;
import com.codegym.libraryapp.service.IBookService;
import com.codegym.libraryapp.service.IReaderService;
import com.codegym.libraryapp.util.NotFoundException;
import com.codegym.libraryapp.util.QuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookAppController {
    @Autowired
    IBookService bookService;
    @Autowired
    IReaderService readerService;

    @GetMapping("/hireBook")
    public String showBookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "hireBook";
    }

    @GetMapping("/hire")
    public String hireBook(@RequestParam(defaultValue = "1") int id, RedirectAttributes redirectAttributes) throws QuantityException {
        Book book = bookService.findById(id);
        int currentQuantity = book.getQuantity();
        if (currentQuantity == 0) {
            throw new QuantityException();
        }
        book.setQuantity(currentQuantity - 1);
        bookService.save(book);
        int codeRandom = (int) Math.floor((Math.random() * 999999) + 100000);
        String codeBook = String.valueOf(codeRandom);
        redirectAttributes.addFlashAttribute("success", "Mã thuê sách: " + codeBook);
        Reader reader = new Reader();
        reader.setCodeBook(codeBook);
        reader.setBook(book);
        readerService.save(reader);
        return "redirect:/book/hireBook";
    }

    @ExceptionHandler(QuantityException.class)
    public String showErrorPage1() {
        return "errorQuantity";
    }

    @GetMapping("/returnBook")
    public String showReturnPage(Model model) {
        model.addAttribute("reader", new Reader());
        model.addAttribute("bookList", bookService.findAll());
        return "returnBook";
    }

    @PostMapping("/return")
    public String returnBook(Reader reader, RedirectAttributes redirectAttributes) throws NotFoundException {
        Reader readerCheck = readerService.findByCodeBook(reader.getCodeBook());
        if (readerCheck == null) {
            throw new NotFoundException();
        }
        Book book = bookService.findById(readerCheck.getBook().getId());
        int newQuantity = book.getQuantity() + 1;
        book.setQuantity(newQuantity);
        bookService.save(book);
        readerService.deleteById(readerCheck.getId());
        redirectAttributes.addFlashAttribute("success", "Trả sách thành công");
        return "redirect:/book/returnBook";
    }

    @ExceptionHandler(NotFoundException.class)
    public String showErrorPage2() {
        return "errorNotFound";
    }
}
