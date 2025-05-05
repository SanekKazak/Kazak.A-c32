package org.alex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean process = true;
        Service service = new Service("jdbc:mysql://localhost:3306/Java", "root", "1");
        String input;
        do{
            System.out.println("Input something:");
            input = scanner.nextLine();
            if(input.isBlank()){
                System.out.println("Session    String"+service.readAll());
                process = false;
            }else{
                System.out.println(service.write(input));
            }
        }while (process);

    }
}
