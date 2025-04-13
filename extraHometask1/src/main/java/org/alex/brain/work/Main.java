package org.alex.brain.work;

import org.alex.brain.managment.In;
import org.alex.brain.managment.Out;
import org.alex.brain.storage.Storage;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        int workingTime = 8000;
        Thread in = new Thread(new In(storage));
        in.setDaemon(true);
        Thread out = new Thread(new Out(storage));
        out.setDaemon(true);
        in.start();
        out.start();
        try {
            Thread.sleep(workingTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
