package org.docker.jenkin.enitity;


import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "loan")
public class LoanEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loanId;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "no_of_months")
    private int noOfMonths;

    @Column(name = "emi_amount")
    private double emiAmount;

//    @ElementCollection
//    @CollectionTable(name = "emi_status", joinColumns = @JoinColumn(name = "loan_id"))
//    @Column(name = "status")
//    private List<Boolean> emiStatus;

    @ElementCollection
    @CollectionTable(name = "emi_status", joinColumns = @JoinColumn(name = "loan_id"))
    @MapKeyColumn(name = "month") // This column represents the month
    @Column(name = "status") // This column represents the EMI status
    private Map<Integer, Boolean> emiStatus;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "trans_start_date", referencedColumnName = "startDate"),
            @JoinColumn(name = "trans_end_date", referencedColumnName = "endDate")
    })
    private TranscationEnity transcationEnity;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getNoOfMonths() {
        return noOfMonths;
    }

    public void setNoOfMonths(int noOfMonths) {
        this.noOfMonths = noOfMonths;
    }

    public double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(double emiAmount) {
        this.emiAmount = emiAmount;
    }

//    public List<Boolean> getEmiStatus() {
//        return emiStatus;
//    }
//
//    public void setEmiStatus(List<Boolean> emiStatus) {
//        this.emiStatus = emiStatus;
//    }

    public TranscationEnity getTranscationEnity() {
        return transcationEnity;
    }

    public void setTranscationEnity(TranscationEnity transcationEnity) {
        this.transcationEnity = transcationEnity;
    }

 public  LoanEntity(){


 }

    public Map<Integer, Boolean> getEmiStatus() {
        return emiStatus;
    }

    public void setEmiStatus(Map<Integer, Boolean> emiStatus) {
        this.emiStatus = emiStatus;
    }


}
