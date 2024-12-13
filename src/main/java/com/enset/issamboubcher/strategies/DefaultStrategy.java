package com.enset.issamboubcher.strategies;

import com.enset.issamboubcher.entities.Transaction;

public class DefaultStrategy implements NotificationStrategy{

    @Override
    public void handleNotification(String agentName, Transaction transaction) {
        System.out.println("Default handling of notification from " + agentName + ": " + transaction);
    }
}
