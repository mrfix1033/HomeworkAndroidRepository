import java.util.Objects;

public class Generics {
    public static void main(String[] args) {
        String[] firstArray = {"1", "2", "5"};
        String[] secondArray = {"1", "5", "2"};
        System.out.println(equals(firstArray, secondArray));
        swap(secondArray, 1, 2);
        System.out.println(equals(firstArray, secondArray));
    }

    public static <T> boolean equals(T[] firstArray, T[] secondArray) {
        if (firstArray.length != secondArray.length) return false;
        for (int i = 0; i < firstArray.length; i++)
            if (!Objects.equals(firstArray[i], secondArray[i])) return false;
        return true;
    }

    public static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
