import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        String[] stringArray = {"ab", "cd", "ef"};
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) sb.append(s);
        char[] chars = sb.toString().toCharArray();
        System.out.println(Arrays.toString(chars));

        String stroke = "12345";
        String result = String.valueOf(stroke.charAt(0)) + stroke.charAt(stroke.length() - 1);
        System.out.println(result);

        String string = "1203405";
        int firstZero = string.indexOf('0');
        System.out.println(firstZero);
    }
}
