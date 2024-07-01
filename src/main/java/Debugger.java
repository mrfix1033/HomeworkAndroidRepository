import java.util.Arrays;

public class Debugger {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new int[] {1, 2, 3, 4, 5}).filter(n -> (n & 1) == 0).max().getAsInt());
//        System.out.println(String.valueOf("Привет, Александр, с праздником, с Новым Годом".codePoints().mapToObj(c -> {
//            String letter = String.valueOf((char) c);
//            return (char) (letter.toUpperCase().equals(letter) ? letter.toLowerCase() : letter.toUpperCase()).codePointAt(0);
//        }).toArray(i -> new char[] {(char) i})));
    }
}
