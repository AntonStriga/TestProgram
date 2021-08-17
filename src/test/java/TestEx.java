import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class TestEx {

    public static void main(String[] args) throws InterruptedException {
//        Consumer zzz = new Consumer();
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNextInt()) {
//            System.out.print("Введите целое число: ");
//            int i = scanner.nextInt();
//            zzz.accept(i);
//            System.out.println("average: " + zzz.mean());
//        }

        int n = 7;

        int fib1 = 1;
        int fib2 = 1;

        switch (n) {
            case 1 :
                System.out.println("Fibbonachi[" + n + "]= " + fib1);
                break;
            case 2 :
                System.out.println("Fibbonachi[" + n + "]= " + fib2);
                break;
            default:
                int fibN = 0;
                for(int i = 2; i < n; i++) {
                    fibN = fib1 + fib2;
                    fib1 = fib2;
                    fib2 = fibN;
                }
                System.out.println("Fibbonachi[" + n + "]= " + fib2);
        }

        // поиск недостающего числа из ряда

//        int n = 10;
//        int[] array = {1, 2, 3, 4, 5, 6, 8, 9, 10};
//        int sum = 0;
//        for (int i : array) {
//            sum += i;
//        }
//        int controlSum = n * (n + 1) / 2;
//
//        System.out.println("Lost number = " + (controlSum - sum));

        // поиск нескольких недостающих


//        int n = 10;
//        int[] array = {1, 3, 4, 5, 8, 9, 10};

//        int missingCount = n - array.length;
//        BitSet bitSet = new BitSet(n);
//        for (int number : array) {
//            bitSet.set(number - 1);
//        }
//        int lastMissingIndex = 0;
//        System.out.print("Missed numbers: ");
//        for(int i = 0; i < missingCount; i++) {
//            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
//            System.out.print((++lastMissingIndex) + " ");
//        }


        int[] array = {21, 13, 4, 1, 8, 12, 10, 2, 4};

        // сортировка пузырьком
//
//        for(int i = array.length - 1; i > 1; i--) {
//            for(int j = 0; j < i; j++) {
//                if(array[j] > array[j + 1]) {
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                }
//            }
//        }

        // сортировка выбором

//        for(int i = 0; i < array.length - 1; i++){
//            int min = i;
//            for(int j = i + 1; j < array.length; j++){
//                if(array[j] < array[min]){
//                    min = j;
//                }
//            }
//            int temp = array[i];
//            array[i] = array[min];
//            array[min] = temp;
//        }

        // сортировка вставкой

//        for(int i = 1; i < array.length; i++){
//            int temp = array[i];
//            int j = i;
//
//            while(j > 0 && array[j - 1] >= temp){
//                array[j] = array[j - 1];
//                j--;
//            }
//            array[j] = temp;
//        }

        // быстрая сортировка

//        fastSort(array);

        // сортировка слиянием

//        array = joinSort(array);
//
//        for(int elem : array) {System.out.print(elem + " ");}
    }

//    public static void fastSort(int[] array){
//        recursionFastSort(array, 0, array.length - 1);
//    }
//
//    public static void recursionFastSort(int[] array, int min, int max){
//        if((array.length == 0) || (max == min)){
//            return;
//        }
//
//        int middle = min + (max - min) / 2;
//        int middleElement = array[middle];
//
//        int i = min;
//        int j = max;
//
//        while (i <= j) {
//            while(array[i] < middleElement) {
//                i++;
//            }
//
//            while (array[j] > middleElement) {
//                j--;
//            }
//
//            if (i <= j) {
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//                i++;
//                j--;
//            }
//        }
//
//        if(min < j) {
//            recursionFastSort(array, min, j);
//        }
//
//        if(max > i) {
//            recursionFastSort(array, i, max);
//        }
//    }

    public static int[] joinSort (int[] array) {
        int[] sortArray = Arrays.copyOf(array, array.length);
        int[] bufferArray = new int[array.length];
        return recursionJoinSort(sortArray, bufferArray, 0, array.length);
    }

    public static int[] recursionJoinSort(int[] sortArray, int[] bufferArray, int startIndex, int endIndex) {
        if(startIndex >= endIndex - 1) {
            return sortArray;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] firstArray = recursionJoinSort(sortArray, bufferArray, startIndex, middle);
        int[] secondArray = recursionJoinSort(sortArray, bufferArray, middle, endIndex);

        // слияние
        int firstIndex = startIndex;
        int secondIndex = middle;
        int destIndex = startIndex;

        int[] resultArray = firstArray == sortArray ? bufferArray : sortArray;

        while(firstIndex < middle && secondIndex < endIndex) {
            resultArray[destIndex++] = firstArray[firstIndex] < secondArray[secondIndex] ? firstArray[firstIndex++] : secondArray[secondIndex++];
        }

        while (firstIndex < middle) {
            resultArray[destIndex++] = firstArray[firstIndex++];
        }

        while (secondIndex < endIndex) {
            resultArray[destIndex++] = secondArray[secondIndex++];
        }

        return resultArray;
    }
}
