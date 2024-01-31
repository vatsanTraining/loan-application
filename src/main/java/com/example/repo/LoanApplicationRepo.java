package com.example.repo;

import com.example.entity.LoanApplication;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanApplicationRepo extends JpaRepository<LoanApplication,Integer> {

    LoanApplication findByApplicantName(String srchString);


    //LoanApplication updateByApplicationNumberAndLoanAmount(int applicationNumber, double loanAmount);


   @Query(value="update LoanApplication set loanAmount=:amount where applicationNumber=:appNumber",nativeQuery = false)
   @Modifying
   @Transactional
   int updateLoanAmount(@Param("appNumber") int applicationNumber, @Param("amount") double loanAmount);
}
