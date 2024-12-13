package com.enset.issamboubcher;

import com.enset.issamboubcher.entities.Agent;
import com.enset.issamboubcher.entities.Container;
import com.enset.issamboubcher.entities.Transaction;
import com.enset.issamboubcher.entities.TransactionType;
import com.enset.issamboubcher.strategies.HistoryStrategy;

public class Main {
    public static void main(String[] args) {
        // Create a container instance
        Container container = Container.getInstance();

        // Create agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");

        // Add agents to the container
        container.addAgent(agent1);
        container.addAgent(agent2);

        // Create transactions
        Transaction transaction1 = new Transaction.Builder()
                .setId("T1")
                .setDate("2023-01-01")
                .setAmount(100.0)
                .setType(TransactionType.VENTE)
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .setId("T2")
                .setDate("2023-01-02")
                .setAmount(200.0)
                .setType(TransactionType.ACHAT)
                .build();

        // Add transactions to agents
        agent1.addTransaction(transaction1);
        agent2.addTransaction(transaction2);

        // Display all agents
        container.displayAllAgents();

        // Get and print the biggest transaction for agent1
        Transaction biggestTransaction = agent1.getBiggestTransaction();
        System.out.println("Biggest transaction for Agent1: " + biggestTransaction.getAmount());

        // Change notification strategy for agent2
        agent2.setNotificationStrategy(new HistoryStrategy());

        // Add observer to agent1
        agent1.addObserver(agent2);

        // Notify observers by adding a new transaction to agent1
        Transaction transaction3 = new Transaction.Builder()
                .setId("T3")
                .setDate("2023-01-03")
                .setAmount(300.0)
                .setType(TransactionType.VENTE)
                .build();
        agent1.addTransaction(transaction3);

        // Remove agent2 from the container
        container.removeAgent(agent2.getName());

        // Display all agents again
        container.displayAllAgents();
    }
}