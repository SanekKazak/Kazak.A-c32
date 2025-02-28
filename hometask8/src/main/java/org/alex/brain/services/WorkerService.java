package org.alex.brain.services;

import org.alex.brain.workers.Worker;

public class WorkerService {
    public void checkPayment(Worker worker){
        System.out.println(worker.getPaymentValue());
    }
}
