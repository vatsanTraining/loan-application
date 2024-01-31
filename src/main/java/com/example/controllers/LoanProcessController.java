package com.example.controllers;

import com.example.entity.LoanApplication;
import com.example.services.LoanApplicationService;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping(path = "/api/v2/loanapp")
@AllArgsConstructor

public class LoanProcessController {


    LoanApplicationService service;


    @GetMapping(path = "/{pageNo}/{size}/{prop}")

    public List<LoanApplication> getPage(int pageNo, int size, String prop){


           return this.service.findAll(pageNo,size,prop);
    }

}
