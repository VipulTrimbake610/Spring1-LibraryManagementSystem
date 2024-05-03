package com.acciojob.LibraryManagementSystem.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Auther {
    @Id
    private Integer autherId;
    private String autherName;
    private  Integer age;
    private Integer noOfBooks;
    private Double ratings;
    private String emailId;
}
