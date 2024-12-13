package com.enset.issamboubcher.observables;

import com.enset.issamboubcher.entities.Transaction;
import com.enset.issamboubcher.observers.Observer;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Transaction transaction);
}
