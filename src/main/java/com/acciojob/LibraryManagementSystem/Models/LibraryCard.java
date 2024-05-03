package com.acciojob.LibraryManagementSystem.Models;


import com.acciojob.LibraryManagementSystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {
    @Id
    private Integer cardId;
    private Integer noOfBookIssued;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

//    @JoinColumn(referencedColumnName = "emailId")
    @JoinColumn
    @OneToOne
    private Student student;

}
