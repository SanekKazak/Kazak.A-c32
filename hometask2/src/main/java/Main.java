import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        //TASK1 - Дано произвольное число. Необходимо узнать, сколько в конце числа нулей.
        //realization #1 - подсчёт количества нулей в числе
        Random random = new Random();
        long valueTask1 = random.nextLong();
        int counter = 0;
        while(valueTask1 > 0){
            valueTask1 /= 10;
            counter++;
        }
        System.out.println(counter);

        //realization #2 - подсчёт количества нулей в конце числа
        valueTask1 = random.nextLong();
        counter = 0;
        while(valueTask1 > 0){
            if(valueTask1 % 10 == 0){
                counter++;
            }
            valueTask1 /= 10;
        }
        System.out.println(counter);

        //TASK2 считаем интеграл n
        Scanner scanner = new Scanner(System.in);
        int valueTask2 = scanner.nextInt();
        int integral = 1;
        for (int i = 1; i <= valueTask2; i++) {
            integral *= i;
        }
        System.out.println(integral);

        //TASK3 Пользователь вводит два числа.
        // Необходимо найти среднее арифметическое между заданными числами
        int valueTask3_1 = scanner.nextInt();
        int valueTask3_2 = scanner.nextInt();
        int value = 0;
        for(int i = valueTask3_1; i < valueTask3_2+1; i++ ){
            value += i;
        }
        System.out.println(value/(abs(valueTask3_1-valueTask3_2)+1));
    }
}