package com.acciojob.LibraryManagementSystem.Controller;

import com.acciojob.LibraryManagementSystem.Models.Book;
import com.acciojob.LibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/associateBookAndAuther")
    public ResponseEntity associateBookAndAuther(@RequestParam("bookId")Integer bookId, @RequestParam("autherId")Integer autherId){
      try{
          String response = bookService.associateBookAndAuther(bookId,autherId);
          return new ResponseEntity(response, HttpStatus.OK);
      }catch(Exception e){
          return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
      }
    }
}
