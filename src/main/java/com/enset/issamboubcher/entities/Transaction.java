package com.enset.issamboubcher.entities;

import com.enset.issamboubcher.aspects.Log;

public class Transaction {
    private String id;
    private String date;
    private double amount;
    private TransactionType type;

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.amount = builder.amount;
        this.type = builder.type;
    }

    public static class Builder {
        private String id;
        private String date;
        private double amount;
        private TransactionType type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setType(TransactionType type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
