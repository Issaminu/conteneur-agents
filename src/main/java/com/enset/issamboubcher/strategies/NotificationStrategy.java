package com.enset.issamboubcher.strategies;

import com.enset.issamboubcher.entities.Transaction;

public interface NotificationStrategy {
    void handleNotification(String agentName, Transaction transaction);
}
