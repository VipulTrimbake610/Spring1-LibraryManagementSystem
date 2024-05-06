package com.acciojob.LibraryManagementSystem.Services;

import com.acciojob.LibraryManagementSystem.Models.Auther;
import com.acciojob.LibraryManagementSystem.Repositories.AutherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class AutherService {

    @Autowired
    AutherRepository autherRepository;
    public String addAuther(Auther auther){
        auther = autherRepository.save(auther);
        return "Auther has been saved to the DB with auther id : "+auther.getAutherId();
    }

    public Auther findAutherById(@RequestParam("id")Integer autherId) throws Exception {
        Optional<Auther> optionalAuther = autherRepository.findById(autherId);
        if(optionalAuther.isEmpty()){
            throw new Exception("Invalid AutherId Entered");
        }
        Auther auther = optionalAuther.get();

        return auther;
    }

}
