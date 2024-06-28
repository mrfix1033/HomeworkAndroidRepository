import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five");
        System.out.println(map);
        System.out.println(getKeys(map));

        Map<Integer, String> newMap = new HashMap<>();
        filterMapWhereValueLengthMoreThan3(map, newMap);
        System.out.println(newMap);
    }

    public static <K, V> Set<K> getKeys(Map<K, V> map) {
        return map.keySet();
    }

    public static <K> void filterMapWhereValueLengthMoreThan3(Map<K, String> map, Map<K, String> newMap) {
        map.forEach((k, v) -> {
            if (v.length() > 3) newMap.put(k, v);
        });
    }
}
