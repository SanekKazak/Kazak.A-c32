package org.alex.brain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;

@AllArgsConstructor
@Getter
@Setter
public class FileSrevice {
    private File base;

    public void getData(){
        getData(this.base);
    }

    private void getData(File current){
        this.base = current;
        if(base.isDirectory()){
            File[] files = base.listFiles();
            if(files != null) {
                for(File file : files){
                    if(file.isDirectory()){
                        System.out.println(file.getName() + " is a directory");
                        getData(file);
                    }
                    if(file.isFile()){
                        System.out.println(file.getName() + " is a file");
                    }
                }
            }
            return;
        }
        if(base.isFile()){
            System.out.println(base.getName() + " is a file");
        }
    }
}
