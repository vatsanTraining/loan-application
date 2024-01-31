package com.example.controllers;


import com.example.entity.LoanApplication;
import com.example.services.LoanApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/api/v3/loanapp")
@AllArgsConstructor
@RestController
public class LoanApplicationXMLcontroller {

    LoanApplicationService service;

    @GetMapping(produces = "application/xml")
    public List<LoanApplication> findAll(){

        return this.service.findAll();
    }
}
