public class FunctionalInterfaces {
    public static void main(String[] args) {
        Printable<Object> normalPrint = new Printable<Object>() {
            @Override
            public void print(Object toPrint) {
                System.out.println(toPrint);
            }
        };
        normalPrint.print("Это строка");
        Printable<String> reversedPrint = string -> System.out.println(new StringBuilder(string).reverse());
        reversedPrint.print("акортс яатунревереп алыб отЭ");
        Printable<Integer> printNegativeNumber = FunctionalInterfaces::printNegativeInt;
        printNegativeNumber.print(0xFFFFFFFF + 1);
        Concationble normalConcationble = (firstString, secondString) -> firstString + secondString;
        normalPrint.print(normalConcationble.concat("Первый", " второй"));
        Concationble reverseConcationble = (firstString, secondString) -> secondString + firstString;
        normalPrint.print(reverseConcationble.concat("второй", "Первый "));
    }

    public static void printNegativeInt(int number) {
        System.out.println(-number);
    }
}

@FunctionalInterface
interface Printable<T> {
    void print(T toPrint);
}

@FunctionalInterface
interface Concationble {
    String concat(String firstString, String secondString);
}