package com.enset.issamboubcher.observers;

import com.enset.issamboubcher.observables.Observable;
import com.enset.issamboubcher.entities.Transaction;

public interface Observer {
    void update(Transaction transaction);
    void subscribe(Observable observable);
}
