package com.example.services;

import com.example.entity.LoanApplication;
import com.example.repo.LoanApplicationRepo;
import com.example.utils.ElementNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanApplicationService {

    private LoanApplicationRepo repo;

    public List<LoanApplication> findAll() {
        return this.repo.findAll();
    }

    public LoanApplication findById(int id) {

        return this.repo.findById(id).orElseThrow(()->new ElementNotFoundException("Element With Given ID Not Found"));
    }

    public LoanApplication save(LoanApplication entity) {

        return this.repo.save(entity);
    }

    public LoanApplication findByApplicantName(String applicantName) {

        return this.repo.findByApplicantName(applicantName);
    }

    public List<LoanApplication> findAll(int pageNo,int size,String propName) {

        PageRequest page = PageRequest.of(pageNo,size,Sort.by(propName));

        return this.repo.findAll(page).stream().toList();

    }
    public int updateAmount(double amount, int appLicationNumber) {

       return  this.repo.updateLoanAmount(appLicationNumber,amount);
    }

    public LoanApplication remove(LoanApplication entity) {

          if(this.repo.existsById(entity.getApplicationNumber())){
              this.repo.delete(entity);
          }

          return entity;
    }
}
