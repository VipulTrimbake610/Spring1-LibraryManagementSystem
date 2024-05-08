package com.acciojob.LibraryManagementSystem.Models;

import com.acciojob.LibraryManagementSystem.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;

@Entity
@Table(name =  "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String transactionId;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date issueDate;
    private Date returnDate;

    private  Integer fineAmt;

    @JoinColumn
    @ManyToOne
    LibraryCard card;

    @JoinColumn
    @ManyToOne
    Book book;

}
