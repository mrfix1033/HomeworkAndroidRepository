public class Exceptions {
    public static void main(String[] args) {
        System.out.println(divideBy2(10));
        System.out.println(divideBy2(4));
        try {
            System.out.println(divideBy2(5));
        } catch (ArithmeticException exception) {
            System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
        validateString("Это строка");
        try {
            validateString("GIMME EXCEPTION PLZ4933i2429924024082348428034823427348248234926");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getClass().getName() + ": " + exception.getMessage());
        }
    }

    /**
     * @param number that is divisible by 2
     * @throws ArithmeticException if number is uneven
     */
    public static int divideBy2(int number) throws ArithmeticException {
        if ((number & 1) == 1) throw new ArithmeticException("Number " + number + " is uneven");
        return number / 2;
    }

    /**
     * @param string that isn't contains digits
     * @throws IllegalArgumentException if string contains digits
     */
    public static void validateString(String string) throws IllegalArgumentException {
        if (string.chars().anyMatch(c -> '0' <= c && c <= '9'))
            throw new IllegalArgumentException("String \"" + string + "\" contains digits");
    }
}
