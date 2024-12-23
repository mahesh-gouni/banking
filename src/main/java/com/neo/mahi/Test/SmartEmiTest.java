package com.neo.mahi.Test;

import com.neo.mahi.enitity.TranscationComposite;
import com.neo.mahi.service.SmartEmiService;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SmartEmiTest {

    public static void main(String[] args) {
        SmartEmiService smart= new SmartEmiService();

        double targetAmount = 20000.0;
        int noOfMontsOfSEMI=3;

// their is a change of amojnt transctios are duplicate that y composite key is used
        TranscationComposite key = new TranscationComposite();
        LocalDateTime startDateTime10 = LocalDateTime.of(2024, 1, 1, 10, 39, 0);
        key.setStartDate(Timestamp.valueOf(startDateTime10));
        LocalDateTime endDateTime10 = LocalDateTime.of(2024, 1, 1, 10, 40, 0);
        key.setEndDate(Timestamp.valueOf(endDateTime10));

        smart.insertTransactionAndLoan(key,targetAmount,noOfMontsOfSEMI);

    }
}
