package com.neo.mahi.service;

import com.neo.mahi.enitity.LoanEntity;
import com.neo.mahi.enitity.TranscationComposite;
import com.neo.mahi.enitity.TranscationEnity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.HashMap;
import java.util.Map;

public class SmartEmiService {

    public void insertTransactionAndLoan(TranscationComposite key, double targetAmount, int noOfMonths) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();


            Query transactionQuery = entityManager.createQuery("SELECT t FROM TranscationEnity t WHERE t.id = :key", TranscationEnity.class);
            transactionQuery.setParameter("key", key);
            TranscationEnity transaction = (TranscationEnity) transactionQuery.getSingleResult();

            if (transaction != null) {
                if (transaction.getAmount() == targetAmount) {
                    // Update transaction
                    transaction.setDebit(false);
                    entityManager.merge(transaction);
                    System.out.println("Transaction updated to smartemi.");


                    LoanEntity loan = new LoanEntity();
                    loan.setLoanAmount(targetAmount);
                    loan.setNoOfMonths(noOfMonths);
                    loan.setEmiAmount(targetAmount / noOfMonths);
                    loan.setTranscationEnity(transaction);


//                    List<Boolean> emiStatus = new ArrayList<>();
//                    for (int i = 0; i < noOfMonths; i++) {
//                        emiStatus.add(false);
//                    }
//                    loan.setEmiStatus(emiStatus);
                    Map<Integer, Boolean> emiStatus = new HashMap<>();
                    for (int i = 1; i <= noOfMonths; i++) {
                        emiStatus.put(i, false); // Initially unpaid
                    }
                    loan.setEmiStatus(emiStatus);

                    entityManager.persist(loan);
                    System.out.println("Loan entity inserted with EMI status.");
                } else {
                    System.out.println("Amount does not match the target amount.");
                }
            } else {
                System.out.println("Transaction not found for the given key.");
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }



    }
}
