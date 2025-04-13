package org.alex.brain.worker;

public class Worker {
    private final int payment;

    public Worker(int payment) {
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "payment=" + payment + "  ";
    }
}
