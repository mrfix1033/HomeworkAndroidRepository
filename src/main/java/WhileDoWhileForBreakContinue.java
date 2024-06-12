public class WhileDoWhileForBreakContinue {
    public static void main(String[] args) {
        int number = 0;
        while (++number < 50) if (number % 3 == 0) System.out.println(number);

        int sum = 0;
        for (int i = 1; i < 100; i++) sum += i;
        System.out.println(sum);
    }
}
