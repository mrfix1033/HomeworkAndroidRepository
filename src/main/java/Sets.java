import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<String> firstSet = Set.of("green", "red", "blue", "cyan"), secondSet = Set.of("red", "yellow", "purple"), contained = new HashSet<>();
        getContainedInBoth(firstSet, secondSet, contained);
        System.out.println(contained);
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
