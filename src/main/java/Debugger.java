import java.util.Arrays;

public class Debugger {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new int[]{1, 2, 3, 4, 5}).filter(n -> (n & 1) == 0).max().getAsInt());

        String string = "Привет, Александр, с праздником, с Новым Годом";
        StringBuilder newString = new StringBuilder();
        for (char c : string.toCharArray()) {
            String letter = String.valueOf(c);
            newString.append((letter.toUpperCase().equals(letter) ? letter.toLowerCase() : letter.toUpperCase()).charAt(0));
        }
        System.out.println(newString);
//        System.out.println(String.valueOf("Привет, Александр, с праздником, с Новым Годом".codePoints().mapToObj(c -> {
//            String letter = String.valueOf((char) c);
//            return (char) (letter.toUpperCase().equals(letter) ? letter.toLowerCase() : letter.toUpperCase()).codePointAt(0);
//        }).toArray()));
    }
}
