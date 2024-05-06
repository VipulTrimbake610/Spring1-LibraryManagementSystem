package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Models.Auther;
import com.acciojob.LibraryManagementSystem.Models.Book;
import com.acciojob.LibraryManagementSystem.Repositories.AutherRepository;
import com.acciojob.LibraryManagementSystem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AutherRepository autherRepository;

    public String addBook(Book book){
        book = bookRepository.save(book);
        return "Book has been saved to the db with bookId : "+book.getBookId();
    }

    public String associateBookAndAuther(Integer bookId, Integer autherId) throws Exception{
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Entered book id is invalid!");
        }

        Optional<Auther> optionalAuther = autherRepository.findById(autherId);
        if(optionalAuther.isEmpty()){
            throw  new Exception("Entered auther id is invalid!");
        }

        Book book = optionalBook.get();
        Auther auther = optionalAuther.get();
        book.setAuther(auther);
        auther.setNoOfBooks(auther.getNoOfBooks()+1);

        bookRepository.save(book);

        return "Book and auther have been associated!";

    }
}
