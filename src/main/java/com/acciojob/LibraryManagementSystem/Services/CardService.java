package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Enum.CardStatus;
import com.acciojob.LibraryManagementSystem.Models.LibraryCard;
import com.acciojob.LibraryManagementSystem.Models.Student;
import com.acciojob.LibraryManagementSystem.Repositories.CardRepository;
import com.acciojob.LibraryManagementSystem.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.PrimitiveIterator;

@Service
public class CardService {


    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;

    public String addCard(){

        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.NEW);
        card = cardRepository.save(card);
        return "The card has been generated with the cardId : "+card.getCardId();
    }

    public String associateCardAndStudent(Integer cardId, Integer studentId){
        LibraryCard card = cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();

        card.setStudent(student);

        return "Library Card has been Assigned to Stduent";
    }
}
