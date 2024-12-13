package com.enset.issamboubcher.entities;

import com.enset.issamboubcher.aspects.Cacheable;
import com.enset.issamboubcher.aspects.Log;
import com.enset.issamboubcher.observables.Observable;
import com.enset.issamboubcher.observers.Observer;
import com.enset.issamboubcher.strategies.DefaultStrategy;
import com.enset.issamboubcher.strategies.NotificationStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements Observer, Observable {
    public String name;
    public List<Transaction> transactions;
    public List<Observer> observers;
    private NotificationStrategy notificationStrategy;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setNotificationStrategy(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }


    public Agent(String name){
        this.name = name;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.notificationStrategy=new DefaultStrategy();
    }

    public Agent(String name, List<Transaction> transactions, List<Observer> observers) {
        this.name = name;
        this.transactions = transactions;
        this.observers = observers;
        this.notificationStrategy=new DefaultStrategy();
    }
    public Agent(String name, List<Transaction> transactions, List<Observer> observers, NotificationStrategy notificationStrategy) {
        this.name = name;
        this.transactions = transactions;
        this.observers = observers;
        this.notificationStrategy = notificationStrategy;
    }

    @Log
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(transaction);
        }
    }

    @Override
    public void update(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void subscribe(Observable observable) {
        observable.addObserver(this);
    }

    public void printAgent(){
        System.out.println("Agent{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                "}");
    }

    @Cacheable
    public Transaction getBiggestTransaction(){
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);
    }
}
