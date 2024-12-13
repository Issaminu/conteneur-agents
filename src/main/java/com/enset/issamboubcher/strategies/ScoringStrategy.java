package com.enset.issamboubcher.strategies;

import com.enset.issamboubcher.entities.Transaction;
import com.enset.issamboubcher.entities.TransactionType;

public class ScoringStrategy  implements NotificationStrategy {
    private double score = 0;

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        if (TransactionType.ACHAT==transaction.getType()) {
            score -= transaction.getAmount();
        } else if (TransactionType.VENTE==transaction.getType()) {
            score += transaction.getAmount();
        }
        System.out.println("Updated score after transaction from " + agentName + ": " + score);
    }

    public double getScore() {
        return score;
    }
}
