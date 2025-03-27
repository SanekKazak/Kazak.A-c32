package org.alex.brain.process;

import org.alex.brain.storage.Storage;

public class In implements Runnable{
    final Storage marker;

    public In(Storage marker) {
        this.marker = marker;
    }
    /*
    Если нужно чтобы склад сначала до краев наполнялся а потом только
    начинал разгружаться
    @Override
    public void run() {
        boolean null = true;
        synchronized (marker){
            while(null){
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for(int i = 0; i<3; i++){
                    if(Storage.content+1 <= Storage.size){
                        Storage.content = Storage.content + 1;
                        System.out.println("+ " + Storage.content);
                    }else{
                        null = false;
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
                    if(Storage.content+1 <= Storage.size){
                        Storage.content = Storage.content + 1;
                        System.out.println("+ " + Storage.content);
                    }
                }
            }
        }
    }
}
