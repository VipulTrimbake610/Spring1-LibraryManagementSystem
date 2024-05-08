package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Enum.CardStatus;
import com.acciojob.LibraryManagementSystem.Enum.TransactionStatus;
import com.acciojob.LibraryManagementSystem.Models.Book;
import com.acciojob.LibraryManagementSystem.Models.LibraryCard;
import com.acciojob.LibraryManagementSystem.Models.Transaction;
import com.acciojob.LibraryManagementSystem.Repositories.BookRepository;
import com.acciojob.LibraryManagementSystem.Repositories.CardRepository;
import com.acciojob.LibraryManagementSystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(Integer bookId, Integer cardId) throws Exception{
        Book book = bookRepository.findById(bookId).get();
        LibraryCard card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();
//      FAILURE : If the book is issued
        if(book.getIsIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            throw new Exception("Book is already issued!");
        }

//      FAILURE : noOfBookIssued has reached limit 3
        if(card.getNoOfBookIssued() == 3){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            throw new Exception("Card book issue limit is reached");
        }

//        SUCCESS
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setBook(book);
        transaction.setCard(card);
        book.setIsIssued(true);
        card.setNoOfBookIssued(card.getNoOfBookIssued()+1);
        transactionRepository.save(transaction);
        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction is saved with transactionId : "+transaction.getTransactionId();
    }
}
