import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TASK1 - Дано произвольное число. Необходимо узнать, сколько в конце числа нулей.
        //realization #1 - подсчёт количества нулей в числе
        Random random = new Random();
        long valueTask1 = random.nextLong(1000000);
        for(int i=0;;){
            if(valueTask1 < 10){
                System.out.println(i);
                break;
            }
            valueTask1 /= 10;
            i++;
        }

        //realization #2 - подсчёт количества нулей в конце числа
        valueTask1 = random.nextLong(1000000);
        for(int i = 0;;){
            if(valueTask1%10==0){
                i++;
                valueTask1 /= 10;
            } else {
                System.out.println(i);
                break;
            }
        }

        //TASK2 считаем интеграл n
        Scanner scanner = new Scanner(System.in);
        int valueTask2 = scanner.nextInt();
        int integral = 1;
        while(valueTask2 > 0){
            integral *= valueTask2;
            valueTask2--;
        }
        System.out.println(integral);

        //TASK3 Пользователь вводит два числа.
        // Необходимо найти среднее арифметическое между заданными числами
        int valueTask3_1 = scanner.nextInt();
        int valueTask3_2 = scanner.nextInt();
        System.out.println((double)(valueTask3_2+valueTask3_1)/2);
    }
}