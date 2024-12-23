package com.neo.mahi.Test;

import com.neo.mahi.enitity.CardEnity;
import com.neo.mahi.enitity.TranscationEnity;
import com.neo.mahi.enitity.UserEnity;
import com.neo.mahi.service.AddingService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddingTest {

    public static void main(String[] args) {

        AddingService service = new AddingService();

        UserEnity user = new UserEnity();
        user.setUserName("Mahesh");

        service.addingUser(user);

        CardEnity card = new CardEnity();
        card.setCardType("Credit card");
        card.setCardLimit(500000.00);
        card.setUserEnity(user);

        service.addCard(card);



        TranscationEnity transaction1 = new TranscationEnity();
        LocalDateTime startDateTime = LocalDateTime.of(2024, 1, 1, 8, 30, 0);
        transaction1.setStartDate(Timestamp.valueOf(startDateTime));
        LocalDateTime endDateTime = LocalDateTime.of(2024, 1, 1, 8, 31, 0);
        transaction1.setEndDate(Timestamp.valueOf(endDateTime));
        transaction1.setAmount(2000);
        transaction1.setDebit(true);
        transaction1.setCardEnity(card);


        TranscationEnity transaction2 = new TranscationEnity();
        LocalDateTime startDateTime2 = LocalDateTime.of(2024, 1, 1, 8, 32, 0);
        transaction2.setStartDate(Timestamp.valueOf(startDateTime2));
        LocalDateTime endDateTime2 = LocalDateTime.of(2024, 1, 1, 8, 33, 0);
        transaction2.setEndDate(Timestamp.valueOf(endDateTime2));
        transaction2.setAmount(2000);
        transaction2.setDebit(true);
        transaction2.setCardEnity(card);


        TranscationEnity transaction3 = new TranscationEnity();
        LocalDateTime startDateTime3 = LocalDateTime.of(2024, 1, 1, 9, 34, 0);
        transaction3.setStartDate(Timestamp.valueOf(startDateTime3));
        LocalDateTime endDateTime3 = LocalDateTime.of(2024, 1, 1, 9, 35, 0);
        transaction3.setEndDate(Timestamp.valueOf(endDateTime3));
        transaction3.setAmount(2000);
        transaction3.setDebit(true);
        transaction3.setCardEnity(card);



        TranscationEnity transaction4 = new TranscationEnity();
        LocalDateTime startDateTime4 = LocalDateTime.of(2024, 1, 1, 9, 36, 0);
        transaction4.setStartDate(Timestamp.valueOf(startDateTime4));
        LocalDateTime endDateTime4 = LocalDateTime.of(2024, 1, 1, 9, 38, 0);
        transaction4.setEndDate(Timestamp.valueOf(endDateTime4));
        transaction4.setAmount(2000);
        transaction4.setDebit(true);
        transaction4.setCardEnity(card);




        TranscationEnity transaction5 = new TranscationEnity();
        LocalDateTime startDateTime5 = LocalDateTime.of(2024, 1, 1, 9, 40, 0);
        transaction5.setStartDate(Timestamp.valueOf(startDateTime5));
        LocalDateTime endDateTime5 = LocalDateTime.of(2024, 1, 1, 9, 45, 0);
        transaction5.setEndDate(Timestamp.valueOf(endDateTime5));
        transaction5.setAmount(2000);
        transaction5.setDebit(true);
        transaction5.setCardEnity(card);



        TranscationEnity transaction6 = new TranscationEnity();
        LocalDateTime startDateTime6 = LocalDateTime.of(2024, 1, 1, 9, 48, 0);
        transaction6.setStartDate(Timestamp.valueOf(startDateTime6));
        LocalDateTime endDateTime6 = LocalDateTime.of(2024, 1, 1, 9, 50, 0);
        transaction6.setEndDate(Timestamp.valueOf(endDateTime6));
        transaction6.setAmount(2000);
        transaction6.setDebit(true);
        transaction6.setCardEnity(card);



        TranscationEnity transaction7 = new TranscationEnity();
        LocalDateTime startDateTime7 = LocalDateTime.of(2024, 1, 1, 10, 30, 0);
        transaction7.setStartDate(Timestamp.valueOf(startDateTime7));
        LocalDateTime endDateTime7 = LocalDateTime.of(2024, 1, 1, 10, 32, 0);
        transaction7.setEndDate(Timestamp.valueOf(endDateTime7));
        transaction7.setAmount(2000);
        transaction7.setDebit(true);
        transaction7.setCardEnity(card);



        TranscationEnity transaction8 = new TranscationEnity();
        LocalDateTime startDateTime8 = LocalDateTime.of(2024, 1, 1, 10, 33, 0);
        transaction8.setStartDate(Timestamp.valueOf(startDateTime8));
        LocalDateTime endDateTime8 = LocalDateTime.of(2024, 1, 1, 10, 35, 0);
        transaction8.setEndDate(Timestamp.valueOf(endDateTime8));
        transaction8.setAmount(2000);
        transaction8.setDebit(true);
        transaction8.setCardEnity(card);




        TranscationEnity transaction9 = new TranscationEnity();
        LocalDateTime startDateTime9 = LocalDateTime.of(2024, 1, 1, 10, 36, 0);
        transaction9.setStartDate(Timestamp.valueOf(startDateTime9));
        LocalDateTime endDateTime9 = LocalDateTime.of(2024, 1, 1, 10, 38, 0);
        transaction9.setEndDate(Timestamp.valueOf(endDateTime9));
        transaction9.setAmount(2000);
        transaction9.setDebit(true);
        transaction9.setCardEnity(card);

        TranscationEnity transaction10 = new TranscationEnity();
        LocalDateTime startDateTime10 = LocalDateTime.of(2024, 1, 1, 10, 39, 0);
        transaction10.setStartDate(Timestamp.valueOf(startDateTime10));
        LocalDateTime endDateTime10 = LocalDateTime.of(2024, 1, 1, 10, 40, 0);
        transaction10.setEndDate(Timestamp.valueOf(endDateTime10));
        transaction10.setAmount(20000);
        transaction10.setDebit(true);
        transaction10.setCardEnity(card);



        List<TranscationEnity> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);
        transactions.add(transaction7);
        transactions.add(transaction8);
        transactions.add(transaction9);
        transactions.add(transaction10);

        service.addTransactions(transactions, card.getCardId());











    }
}
