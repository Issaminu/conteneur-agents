package com.enset.issamboubcher.strategies;

import com.enset.issamboubcher.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements NotificationStrategy {
    private List<Transaction> history = new ArrayList<>();

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        history.add(transaction);
        System.out.println("Transaction from " + agentName + " added to history: " + transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }
}
