package com.neo.mahi.Test;


import com.neo.mahi.service.MontlyBillService;

import java.util.Map;

public class MontlyBillTest {

    public static void main(String[] args) {
        MontlyBillService m = new MontlyBillService();
        Map<String, Double> monthlyTotals =m.getTotalAdjustedAmountByMonthh();


        if (monthlyTotals != null) {
            monthlyTotals.forEach((month, total) -> {
                System.out.println(month + ": " + total);
            });
        } else {
            System.out.println("No data found.");
        }
    }
}
