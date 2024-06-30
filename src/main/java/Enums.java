import java.util.List;
import java.util.Objects;

public class Enums {
    public static void main(String[] args) {
        for (Alphabet letter : Alphabet.values())
            System.out.println(letter + " - " + getOrdinalLetter(letter));

        List<Person> people = List.of(
                new Person("Mihail", 23, Gender.MALE),
                new Person("Tatiana", 42, Gender.FEMALE),
                new Person("Tatiana", 42, Gender.FEMALE),
                new Person("Elena", 8, Gender.FEMALE),
                new Person("Nikolai", 64, Gender.MALE),
                new Person("Ekaterina", 12, Gender.FEMALE),
                new Person("Danya", 43, Gender.MALE),
                new Person("Sanya", 32, Gender.MALE),
                new Person("Andrei", 21, Gender.FEMALE),
                new Person("Sasha", 42, Gender.MALE),
                new Person("Alexa", 43, Gender.FEMALE)
        );

        List<Person> women = filterPersonsByGender(people, Gender.FEMALE);
        List<Person> men = filterPersonsByGender(people, Gender.MALE);
        System.out.println("Девушки: " + women);
        System.out.println("Мужчины: " + men);
    }

    static List<Person> filterPersonsByGender(List<Person> people, Gender gender) {
        return people.stream().filter(person -> person.gender() == gender).toList();
    }

    static int getOrdinalLetter(Alphabet letter) {
        return letter.ordinal() + 1;
    }
}

enum Alphabet {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
}

enum Gender {
    MALE, FEMALE
}

record Person(String name, int age, Gender gender) {
    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}