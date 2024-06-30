import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        Filter<Integer> filter = num -> num > 0;
        Operation<int[], Integer> operation = (array -> {
            int sum = 0;
            for (int number : array)
                if (filter.filter(number))
                    sum += number;
            return sum;
        });
        System.out.println(operation.operate(new int[]{1, 1, 1, 1, 1, -1, -2, -3, -4}));
        Operation<List<String>, String> operation1 = list -> Collections.max(list, Comparator.comparingInt(String::length));
        System.out.println(operation1.operate(List.of("Список", "слов", "ясамоедлинноеслово")));
    }
}

interface Operation<T, R> {
    R operate(T object);
}

interface Filter<T> {
    boolean filter(T object);
}

