package org.alex.brain.managment;

import org.alex.brain.storage.Storage;

public class Out implements Runnable{
    final Storage gates;

    public Out(Storage gates) {
        this.gates = gates;
    }

    @Override
    public void run() {
        for(;;){
            synchronized (gates){
                if(Storage.value-1 >= 0){
                    Storage.value = Storage.value - 1;
                    System.out.println("-1 now " + Storage.value);
                }
            }
        }
    }
}
