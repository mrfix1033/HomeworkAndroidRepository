import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        List<String> arrayList = List.of("orange", "purple", "yellow", "green", "blue");
        System.out.println(contains(arrayList, "orange"));
        System.out.println(contains(arrayList, "red"));

        LinkedList<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 32, 5, 6));
        System.out.println(linkedList);
        swapExtremes(linkedList);
        System.out.println(linkedList);
    }

    public static <T> boolean contains(Collection<T> collection, T object) {
        return collection.contains(object);
    }

    // Asymptotic: O(1)
    public static <T> void swapExtremes(LinkedList<T> linkedList) {
        T temp = linkedList.pollFirst();
        linkedList.addFirst(linkedList.pollLast());
        linkedList.addLast(temp);
    }
}
