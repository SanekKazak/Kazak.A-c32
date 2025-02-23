import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final int length = 5;
        int[] initialArray = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            initialArray[i] = random.nextInt(10);
        }

        //N1
        //Дан одноместный массив целых чисел.
        // Необходимо получить второй, который будут зеркальной копией
        // первого (элементы наоборот - с последнего до первого)
        int[] array1 = new int[length];
        for (int i = 0; i < length; i++) {
            array1[i] = initialArray[length - 1 - i];
        }

        //N2
        //Дан массив целых чисел.
        //Необходимо удалить элемент, расположенный по середине.
        int[] array2 = new int[length - 1];
        for (int i = 0, j = 0; i < length; j++, i++) {
            if (i == length / 2) {
                i++;
            }
            array2[j] = initialArray[i];
        }

        //N3
        //Даны два массива целых чисел.
        //Необходимо найти все элементы (собрать из них массив) которые не встречаются
        //в обоих массивах одновременно.
        //Если надо будет напишу комментарии для исправленного мра ;D,
        //максимально диетический код.
        int[] array3_1 = new int[length];
        int[] array3_2 = new int[length];
        int[] array3_3 = new int[length * 2];

        for (int i = 0; i < length; i++) {
            array3_1[i] = random.nextInt(10);
        }
        for (int i = 0; i < length; i++) {
            array3_2[i] = random.nextInt(10);
        }

        for (int i = 0; i < length; i++) {
            array3_3[i] = array3_1[i];
        }
        for (int i = 0; i < length; i++) {
            array3_3[i + length] = array3_2[i];
        }

        boolean isHere = false;
        for (int i = 0; i < array3_3.length; i++) {
            for (int j = i + 1; j < array3_3.length; j++) {
                if (array3_3[i] == array3_3[j] && array3_3[i] > 0) {
                    array3_3[j] = -1;
                    isHere = true;
                    continue;
                }
            }
            if (isHere) {
                array3_3[i] = -1;
                isHere = false;
            }
        }

        int countOfPositiveValues = 0;
        for (int i = 0; i < array3_3.length; i++) {
            if (array3_3[i] > 0) {
                countOfPositiveValues++;
            }
        }
        int[] resultArray = new int[countOfPositiveValues];

        for (int i = 0, j = 0; i < array3_3.length; i++) {
            if (array3_3[i] > 0) {
                resultArray[j] = array3_3[i];
                j++;
            }
        }

        //N4
        //Дан массив целых чисел с дублирующими элементами.
        //Необходимо найти элемент, который встречается максимальное число раз
        int[] array4 = new int[length];
        int previousCounter = 0;
        int presentCounter = 1;
        int commonValue = 0;

        for (int i = 0; i < length; i++) {
            array4[i] = random.nextInt(2);
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array4[i] == array4[j]) {
                    presentCounter++;
                }
            }
            if (previousCounter < presentCounter) {
                commonValue = array4[i];
                previousCounter = presentCounter;
                presentCounter = 1;
            }
        }

    }
}
