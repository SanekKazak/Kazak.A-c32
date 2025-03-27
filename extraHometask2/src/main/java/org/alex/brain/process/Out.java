package org.alex.brain.process;

import org.alex.brain.storage.Storage;

public class Out implements Runnable{
    final Storage marker;

    public Out(Storage marker) {
        this.marker = marker;
    }
    /*
    Если нужно чтобы склад сначала до конца разгружался а потом только
    начинал
    @Override
    public void run() {
        boolean full = true;
        synchronized (marker){
            while(full){
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for(int i = 0; i<3; i++){
                    if(Storage.content-1 >= 0){
                        Storage.content = Storage.content - 1;
                        System.out.println("- " + Storage.content);
                    }else{
                        full = false
                    }
                }
            }
        }
    }
     */
    @Override
    public void run() {
        while(true){
            synchronized (marker){
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for(int i = 0; i<3; i++){
                    if(Storage.content-1 >= 0){
                        Storage.content = Storage.content - 1;
                        System.out.println("- " + Storage.content);
                    }
                }
            }
        }
    }
}
