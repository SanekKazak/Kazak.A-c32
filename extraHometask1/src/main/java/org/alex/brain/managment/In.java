package org.alex.brain.managment;

import org.alex.brain.storage.Storage;

public class In implements Runnable{
    final Storage gates;

    public In(Storage gates) {
        this.gates = gates;
    }

    @Override
    public void run() {
        for(;;){
            synchronized (gates){
                if(Storage.value+1 <= Storage.maxValue){
                    Storage.value = Storage.value + 1;
                    System.out.println("+1 now " + Storage.value);
                }
            }
        }
    }
}
