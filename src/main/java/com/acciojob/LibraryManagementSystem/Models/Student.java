package com.acciojob.LibraryManagementSystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    private Integer studentId;

    private String name;

    private Integer age;

    private String branch;

    @Column(unique = true,length = 300)
    private String emailId;
    private String address;


}
