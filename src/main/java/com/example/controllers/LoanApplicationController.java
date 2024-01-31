package com.example.controllers;


import com.example.entity.LoanApplication;
import com.example.services.LoanApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/loanapp")
@AllArgsConstructor
@Slf4j
public class LoanApplicationController {


    private LoanApplicationService service;


    @GetMapping(produces = "application/json")
    public List<LoanApplication> findAll(){

        return this.service.findAll();

    }

    @GetMapping(path = "/{id}")
    public LoanApplication findById(@PathVariable("id") int id){

        return this.service.findById(id);

    }

    @GetMapping(path = "/srch/name/{name}")
    public LoanApplication findById(@PathVariable("name") String applicantName){

        return this.service.findByApplicantName(applicantName);

    }
    @PostMapping
    @RolesAllowed("ROLE_ADMIN")
    public ResponseEntity<LoanApplication> save(@RequestBody LoanApplication entity, Principal principal){

       log.info("accessed by user "+principal.getName());

        LoanApplication entityAdded = this.service.save(entity);

        URI location = ServletUriComponentsBuilder
                         .fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getApplicationNumber()).toUri();


        return ResponseEntity.created(location).body(entityAdded);
    }

    @PutMapping
    public LoanApplication update(@RequestBody LoanApplication entity){

        return this.service.save(entity);
    }

    @PatchMapping
    @Operation(summary = "Method Updates the loan amount based on Application Number")
    public ResponseEntity<String> updateAmount(@RequestParam("loanAmount") double amount, @RequestParam("applicationNumber") int appLicationNumber){

        int rowsUpdated = this.service.updateAmount(amount,appLicationNumber);

        return ResponseEntity.ok(rowsUpdated + "Rows Updated");

    }

    @DeleteMapping
   @PreAuthorize("hasRole('ADMIN')")
    public LoanApplication remove(@RequestBody LoanApplication entity){

        return this.service.remove(entity);
    }

}
