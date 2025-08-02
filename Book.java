import java.util.Objects;

class Book implements Comparable<Book> {
    private final String title;
    private final int pages;
    private final int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + " (" + year + "), страниц: " + pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                year == book.year &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.pages, o.pages);
    }
}