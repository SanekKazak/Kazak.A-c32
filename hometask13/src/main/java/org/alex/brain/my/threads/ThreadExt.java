package org.alex.brain.my.threads;

import lombok.AllArgsConstructor;
import org.alex.brain.tools.Marker;

@AllArgsConstructor
public class ThreadExt extends Thread{
    int[] array;
    final Marker marker;
    @Override
    public void run() {
        synchronized (marker){
            int max=-1;
            for(int runner : array){
                if(max<runner){
                    max = runner;
                }
            }
            System.out.println(max);
        }
    }
}
