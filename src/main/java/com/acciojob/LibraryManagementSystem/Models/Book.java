package com.acciojob.LibraryManagementSystem.Models;

import com.acciojob.LibraryManagementSystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private Integer noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Boolean isIssued;

    @JoinColumn
    @ManyToOne
    private Auther auther;

}
