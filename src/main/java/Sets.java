import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<String> firstSet = Set.of("green", "red", "blue", "cyan"), secondSet = Set.of("red", "yellow", "purple"), contained = new HashSet<>();
        getContainedInBoth(firstSet, secondSet, contained);
        System.out.println(contained);

        Set<Integer> numbers = Set.of(1, 3, 2, 4, 16, 18, 17);
        numbers.forEach(num -> System.out.println(num + " -> " + (num > 15 && (num & 1) == 0 ? num : num / 2)));
    }

    public static <cT extends Collection<T>, T> void getContainedInBoth(cT firstCollection, cT secondCollection, Collection<T> container) {
        if (firstCollection.size() < secondCollection.size())
            firstCollection.forEach(e -> {
                if (secondCollection.contains(e)) container.add(e);
            });
        else secondCollection.forEach(e -> {
            if (firstCollection.contains(e)) container.add(e);
        });
    }
}
