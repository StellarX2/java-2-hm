import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Алиса", Arrays.asList(
                new Book("Чистый код", 464, 2008),
                new Book("Эффективная Java", 412, 2018),
                new Book("Параллелизм в Java", 384, 2006),
                new Book("Java 8 в действии", 424, 2014),
                new Book("Java для начинающих", 720, 2005),
                new Book("Сумерки", 1234, 1020)
            )),
            new Student("Боб", Arrays.asList(
                new Book("Чистый код", 464, 2008),
                new Book("Основы Java", 928, 2016),
                new Book("Головоломки Java", 312, 2005),
                new Book("Философия Java", 1150, 2006),
                new Book("Java SE 8", 350, 2017),
                new Book("Spring в действии", 520, 2020)
            ))
        );

        // для каждого студента:
        students.forEach(student -> {
            System.out.println("Студент" + student.getName());

            // обработка книг через стрим
            List<Book> filteredBooks = student.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getPages)) // сортировка по страницам
                .distinct() // уникальные (по equals)
                .filter(book -> book.getYear() > 2000) // только после 2000
                .limit(3) // максимум 3 книги
                .collect(Collectors.toList());

            // вывод книг
            filteredBooks.forEach(book -> System.out.println(" Книга " + book));

            // short-circuit + Optional
            filteredBooks.stream()
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                    year -> System.out.println("Год первой книги: " + year),
                    () -> System.out.println("Книг после 2000 года нет")
                );

            System.out.println(); // пустая строка между студентами
        });
    }
}