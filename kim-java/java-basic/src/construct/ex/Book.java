package construct.ex;

public class Book {
    String title;
    String author;
    int page;

    Book() {
        this("", "");
    }

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    Book(String title, String author, int page) {
        this(title, author);
        this.page = page;
    }

    void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 페이지: " + page);
    }
}
