package org.alex.brain.io;

import java.io.*;

public class IoCustom {
    public static String readText(File file) {
        try(FileReader reader = new FileReader(file)){
            StringBuilder builder = new StringBuilder();
            int i;
            while((i = reader.read()) != -1){
                builder.append((char)i);
            }
            return builder.toString();
        }catch(IOException e){
            System.out.println("Error with reading file");
            return null;
        }
    }

    /*
    Метод разработанный для получения всех частей из текста
    с паттерном - [necessaryKey(вкл) .... extraKey(не вкл)] * N
     */
    public static String getCutTextPart(String text, String extraKey, String necessaryKey) throws Exception{
        StringBuilder result = new StringBuilder();
        String cutPart;
        while(text.contains(necessaryKey)){
            if(text.contains(extraKey)){
                if(text.indexOf(necessaryKey) > text.indexOf(extraKey)){
                    cutPart = text.substring(text.indexOf(extraKey), text.indexOf(necessaryKey));
                    text = text.replaceFirst(cutPart, "");
                }
            }
            if(!text.contains(extraKey)){
                result.append(text);
                return result.toString();
            }
            cutPart = text.substring(text.indexOf(necessaryKey), text.indexOf(extraKey));
            result.append(cutPart);
            text = text.replaceFirst(cutPart, "");
        }
        return result.toString();
    }

    public static void writeElement(String str, String fileName) {
        String path = "C:\\Users\\kazak\\Desktop\\Kazak.A-c32" +
                "\\hometask12\\src\\main\\java\\org\\alex\\brain\\storage\\" +
                fileName.replaceAll("[^a-zA-Zа-яА-Я]","") +
                ".txt";
        try(FileWriter writer = new FileWriter(path)){
            writer.write(str);
        }catch(IOException e){
            System.out.println("Error with writing in file");
        }
    }
}
