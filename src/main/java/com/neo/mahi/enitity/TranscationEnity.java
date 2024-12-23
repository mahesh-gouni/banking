package org.docker.jenkin.enitity;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;


@Entity

@Table(name = "transcation")
@IdClass(TranscationComposite.class)
public class TranscationEnity {


    @Id
    private Timestamp startDate;
    @Id
    private Timestamp endDate;

    private double amount;

     private boolean isDebit;

    @ManyToOne
    @JoinColumn(name = "cardId")
     private CardEnity cardEnity;

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    public CardEnity getCardEnity() {
        return cardEnity;
    }

    public void setCardEnity(CardEnity cardEnity) {
        this.cardEnity = cardEnity;
    }



    public TranscationEnity() {
    }

    @Override
    public String toString() {
        return "TranscationEnity{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", isDebit=" + isDebit +
               ", cardEnity=" + cardEnity +
                '}';
    }

    @OneToOne(mappedBy = "transcationEnity", cascade = CascadeType.ALL)
    private LoanEntity loanEntity;


    public LoanEntity getLoanEntity() {
        return loanEntity;
    }

    public void setLoanEntity(LoanEntity loanEntity) {
        this.loanEntity = loanEntity;
    }
}
