import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class zzz {

    public static void main(String[] args) {

        int[] array = {21, 14, 13, 25, 4, 1, 8, 12, 0, 10, 124, 2, 4, 77};

        // быстрая сортировка

        array = joinSort(array);

        for(int elem : array) {System.out.print(elem + " ");}
    }

    public static int[] joinSort(int[] array){
        int[] sortArray = Arrays.copyOf(array, array.length);
        int[] bufferArray = new int[array.length];

        return recursionJoinSort(sortArray, bufferArray, 0, array.length);
    }

    public static int[] recursionJoinSort(int[] sortArray, int[] bufferArray, int startIndex, int endIndex){
        if(startIndex >= endIndex - 1){
            return sortArray;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] firstArray = recursionJoinSort(sortArray, bufferArray, startIndex, middle);
        int[] secondArray = recursionJoinSort(sortArray, bufferArray, middle, endIndex);

        int firstIndex = startIndex;
        int secondIndex = middle;
        int destIndex = startIndex;

        int[] result = firstArray == sortArray ? bufferArray : sortArray;

        while(firstIndex < middle && secondIndex < endIndex){
            result[destIndex++] = firstArray[firstIndex] < secondArray[secondIndex] ? firstArray[firstIndex++] : secondArray[secondIndex++];
        }

        while(firstIndex < middle) {
            result[destIndex++] = firstArray[firstIndex++];
        }

        while (secondIndex < endIndex) {
            result[destIndex++] = sortArray[secondIndex++];
        }

        return result;
    }

}
