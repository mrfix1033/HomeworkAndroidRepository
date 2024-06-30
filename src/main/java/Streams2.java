import java.util.List;

public class Streams2 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2);
        System.out.println("Сумма четных чисел: " + ints.stream().filter(num -> (num & 1) == 0).reduce(Integer::sum).get());
        System.out.println("Сумма нечетных чисел: " + ints.stream().filter(num -> (num & 1) == 1).reduce(Integer::sum).get());
        System.out.println(ints.stream().distinct().toList());
    }
}
