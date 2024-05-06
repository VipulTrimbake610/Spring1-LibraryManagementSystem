package com.acciojob.LibraryManagementSystem.Controller;

import com.acciojob.LibraryManagementSystem.Models.Auther;
import com.acciojob.LibraryManagementSystem.Services.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auther")
public class AutherController {

    @Autowired
    AutherService autherService;

    @PostMapping("/add")
    public String addAuther(@RequestBody Auther auther){
        return autherService.addAuther(auther);
    }

    @GetMapping("/findAutherById")
    public ResponseEntity findAutherById(@RequestParam("id")Integer autherId){
        try {
            Auther auther = autherService.findAutherById(autherId);
            return new ResponseEntity(auther, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
