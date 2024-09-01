public class Arrays {
    public static void main(String[] args) {
        int[] array = {3, 87, 12, 98, 2, 4, 66};
        for (int i = 0; i < array.length; i++) System.out.print(array[array.length - i - 1] + " ");
        System.out.println();

        Float[] floatArray = {2.3F, 536.4F, 914.2F, -20F};
        java.util.Arrays.sort(floatArray, (f1, f2) -> -Float.compare(f1, f2));
        System.out.println(java.util.Arrays.toString(floatArray));

        int[] array2 = {6, 117, 44, 5, 32, 81, 9};
        for (int num : array2) if ((num & 1) == 0) System.out.print(num + " ");
    }
}
