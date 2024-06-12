public class JavaIfSwitchReturn {
    public static void main(String[] args) {
        int x = 3, y = 5;
        if ((x & 1) == (y & 1))
            System.out.println("Удачное совпадение");

        int day_of_mouth = 5, decada;
        if (day_of_mouth < 11) decada = 1;
        else if (day_of_mouth < 21) decada = 2;
        else decada = 3;
    }
}
