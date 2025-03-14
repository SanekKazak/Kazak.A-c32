package org.alex.brain.io;

import java.io.*;

import static java.lang.Math.abs;

public class IoImpl{
    public String readComposition(File file) {
        try(FileReader reader = new FileReader(file)){
            StringBuilder builder = new StringBuilder();
            int i;
            while((i = reader.read()) != -1){
                builder.append((char)i);
            }
            return builder.toString();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void connectParts(String str, String[] names, String name) {
        StringBuilder builder = new StringBuilder();
        String cutPart = "";
        while(str.contains(name+":")){
            int previous = 1_000_000;
            for(String runner : names){
                if(previous > abs(str.indexOf(runner+":")-str.indexOf(name+":")) && !runner.equals(name)){
                    previous = abs(str.indexOf(runner+":")-str.indexOf(name+":"));
                    cutPart = str.substring(str.indexOf(name+":"), str.indexOf(runner+":")+runner.length()+1);
                }
            }
            builder.append(cutPart);
            str = str.replaceFirst(cutPart, "");
        }
        System.out.println(builder.toString());
    }

//    public void writeElements(String str) {
//        try(FileWriter writer = new FileWriter()){
//
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//    }
}
