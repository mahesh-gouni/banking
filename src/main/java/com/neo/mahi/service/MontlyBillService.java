package com.neo.mahi.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MontlyBillService {

    public Map<String, Double> getTotalAdjustedAmountByMonthh() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateDemo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Map<String, Double> adjustedTotals = new LinkedHashMap<>();

        try {
            entityManager.getTransaction().begin();


            String jpql = "SELECT MONTH(t.startDate) as month, YEAR(t.startDate) as year, SUM(t.amount) as totalAmount " +
                    "FROM TranscationEnity t WHERE t.isDebit = true " +
                    "GROUP BY YEAR(t.startDate), MONTH(t.startDate) " +
                    "ORDER BY YEAR(t.startDate), MONTH(t.startDate)";

            List<Object[]> results = entityManager.createQuery(jpql, Object[].class).getResultList();

            boolean allEmiSetTrue = false;
            Double emiAmount = null;

            for (Object[] result : results) {
                int month = (int) result[0];
                int year = (int) result[1];
                double totalAmount = (double) result[2];
                String monthKey = String.format("%04d-%02d", year, month);

                if (!allEmiSetTrue) {

                    String falseAmountQuery = "SELECT COUNT(*) FROM emi_status WHERE month = :month AND status = false";
                    Long falseAmountCount = (Long) entityManager.createNativeQuery(falseAmountQuery)
                            .setParameter("month", month)
                            .getSingleResult();

                    if (falseAmountCount > 0) {
                        if (emiAmount == null) {

                            String loanQuery = "SELECT l.emiAmount FROM LoanEntity l WHERE l.loanId = :loanId";
                            emiAmount = entityManager.createQuery(loanQuery, Double.class)
                                    .setParameter("loanId", 1) // Adjust loan ID dynamically as needed
                                    .getSingleResult();
                        }


                        if (emiAmount != null) {
                            totalAmount += emiAmount;
                        }

                        // Update the EMI status for the current month (native SQL)
                        String updateEmiStatusQuery = "UPDATE emi_status SET status = true WHERE month = :month ";
                        entityManager.createNativeQuery(updateEmiStatusQuery)
                                .setParameter("month", month)
                                .executeUpdate();

                        // Check if all EMI statuses are now true
                        String checkAllTrueQuery = "SELECT COUNT(*) FROM emi_status WHERE status = false";
                        Long remainingFalseStatus = (Long) entityManager.createNativeQuery(checkAllTrueQuery).getSingleResult();

                        allEmiSetTrue = (remainingFalseStatus == 0);
                    }
                }


                adjustedTotals.put(monthKey, totalAmount);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return null;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return adjustedTotals;
    }

}
