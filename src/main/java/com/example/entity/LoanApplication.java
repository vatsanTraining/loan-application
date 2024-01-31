package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "loan_app_jan_24")
@XmlRootElement
public class LoanApplication {

    @Id
    @Column(name = "application_number")
    private int applicationNumber;

    @Column(name = "applicant_name")
    private String applicantName;

    @Column(name="pan_card_number")
    private String panCardNumber;

    private double loanAmount;


}
