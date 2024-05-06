package com.acciojob.LibraryManagementSystem.Repositories;

import com.acciojob.LibraryManagementSystem.Models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
