import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Алиса", Arrays.asList(
                 new Book("Эффективная Java", 412, 2018),
                new Book("Чистый код", 464, 2008),
                new Book("Параллелизм в Java", 384, 2006),
                new Book("Java 8 в действии", 424, 2014),
                new Book("Java для начинающих", 720, 2005)
            )),
            new Student("Боб", Arrays.asList(
                new Book("Основы Java", 928, 2016),
                new Book("Головоломки Java", 312, 2005),
                new Book("Философия Java", 1150, 2006),
                new Book("Java SE 8", 350, 2017),
                new Book("Spring в действии", 520, 2020)
            ))
        );

        students.stream()
            .peek(System.out::println)
            .map(Student::getBooks)
            .flatMap(Collection::stream)
            .sorted()
            .distinct()
            .filter(b -> b.getYear() > 2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .ifPresentOrElse(
                year -> System.out.println("Год выпуска книги: " + year),
                () -> System.out.println("Книги не найдены")
            );
    }
}