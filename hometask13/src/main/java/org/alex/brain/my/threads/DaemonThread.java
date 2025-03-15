package org.alex.brain.my.threads;

public class DaemonThread implements Runnable {
    @Override
    public void run() {
        int i = 0;
        for(;;){
            System.out.println("Now i am working, iteration: " + i++);
        }
    }
}
