package com.neo.mahi.service;

import com.neo.mahi.enitity.CardEnity;
import com.neo.mahi.enitity.TranscationEnity;
import com.neo.mahi.enitity.UserEnity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AddingService {
    public void addingUser(UserEnity userEntity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);

            entityManager.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void addCard(CardEnity cardEntity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            UserEnity user = entityManager.find(UserEnity.class, cardEntity.getUserEnity().getUserId());

            if (user == null) {
                System.out.println("User not found with ID: " + cardEntity.getUserEnity().getUserId());
            } else {
                cardEntity.setUserEnity(user);
                entityManager.persist(cardEntity);

                entityManager.getTransaction().commit();
                System.out.println("Card saved successfully for user: " + user.getUserName());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addTransactions(List<TranscationEnity> transactions, int cardId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();


            CardEnity card = entityManager.find(CardEnity.class, cardId);

            if (card == null || card.getCardId() != cardId) {
                System.out.println("Card not found with ID: ");
            } else {

                for (TranscationEnity transaction : transactions) {
                    transaction.setCardEnity(card);
                    card.getTranscationEnityList().add(transaction);
                    entityManager.persist(transaction);
                }

                entityManager.getTransaction().commit();
                System.out.println("Transactions added successfully to card: ");
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
