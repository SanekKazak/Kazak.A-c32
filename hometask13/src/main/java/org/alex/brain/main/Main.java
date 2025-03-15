package org.alex.brain.main;

import org.alex.brain.my.threads.DaemonThread;
import org.alex.brain.my.threads.ThreadExt;
import org.alex.brain.my.threads.ThreadImpl;
import org.alex.brain.tools.Marker;

public class Main {
    public static void main(String[] args) {
        Marker marker = new Marker();
        int[] array = {1, 5, 6, 7, 1, 5, 2, 3, 7};
        ThreadExt threadExt = new ThreadExt(array, marker);
        Thread thread = new Thread(new ThreadImpl(array, marker));
        threadExt.start();
        thread.start();

        Thread thread1 = new Thread(new DaemonThread());
        thread1.setDaemon(true);
        thread1.start();

        int i =0;
        while(i != 200_000){
            i++;
            System.out.println("In main now iteration: " + i);
        }
    }
}
