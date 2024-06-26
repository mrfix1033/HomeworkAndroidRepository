import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите данные для записи:");
        String input = scanner.nextLine();
        while (!input.equals("0")) {
            builder.append(input).append('\n');
            System.out.println("Введите что-нибудь ещё (или 0 для завершения):");
            input = scanner.nextLine();
        }

        System.out.println("Введите имя файла:");
        File file = new File(scanner.nextLine());
        while (true) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
                System.out.println("Не удалось создать файл, введите другое имя файла:");
                file = new File(scanner.nextLine());
                continue;
            }
            try (FileWriter fileWriter = new FileWriter(file, true)) {
                fileWriter.append(builder.toString());
                break;
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
                System.out.println("Не удалось открыть файл, введите другое имя файла:");
                file = new File(scanner.nextLine());
            }
        }
        System.out.println("Готово");
    }
}