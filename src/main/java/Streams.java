import java.util.List;
import java.util.Objects;

public class Streams {
    public static void main(String[] args) {
        List<String> list = List.of("add", "remove", "rename", "tp", "info");
        char letter = 'r';
        System.out.println(list.stream().filter(string -> string.getBytes()[0] == letter).count());

        List<PersonForStreams> people = List.of(
                new PersonForStreams("Aleksey", 12),
                new PersonForStreams("Alisa", 16),
                new PersonForStreams("Andrey", 17),
                new PersonForStreams("Anna", 20),
                new PersonForStreams("Artem", 28),
                new PersonForStreams("Artur", 34),
                new PersonForStreams("Alla", 35),
                new PersonForStreams("Alina", 36),
                new PersonForStreams("Alena", 48),
                new PersonForStreams("Arina", 57),
                new PersonForStreams("Alexander", 69),
                new PersonForStreams("Anton", Integer.MAX_VALUE)
        );
        people.stream().filter(person -> person.age() > 30).forEach(System.out::println);
    }
}

record PersonForStreams(String name, int age) {
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}