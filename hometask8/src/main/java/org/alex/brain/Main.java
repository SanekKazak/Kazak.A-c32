package org.alex.brain;

import org.alex.brain.enums.Role;
import org.alex.brain.services.WorkerService;
import org.alex.brain.workers.StartWorker;
import org.alex.brain.workers.Worker;

public class Main {
    public static void main(String[] args) {
        WorkerService workerService = new WorkerService();
        Worker worker1 = new Worker("Alex", 7, Role.OFFICE_MANAGER);
        Worker worker2 = new Worker("Vitalya", 15, Role.DIRECTOR);
        Worker worker3 = new StartWorker("Brant", 0, Role.OFFICE_MANAGER);
        Worker worker4 = new StartWorker("Lev", 0, Role.DIRECTOR);
        workerService.checkPayment(worker1);
        workerService.checkPayment(worker2);
        workerService.checkPayment(worker3);
        workerService.checkPayment(worker4);
    }
}
