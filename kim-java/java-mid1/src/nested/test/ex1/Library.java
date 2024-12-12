package nested.test.ex1;

public class Library {
    private int bookCount;
    private Book[] books;

    private static class Book {
        private String title;
        private String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        void print() {
            System.out.println("도서 제목: " + title + ", 저자: " + author);
        }
    }

    Library(int size) {
        books = new Book[size];
        bookCount = 0;
    }

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);

        if (bookCount >= books.length) {
            System.out.println("도서관 저장 공간이 부족합니다.");
            return;
        }

        books[bookCount++] = newBook;
    }

    public void showBooks() {
        System.out.println("== 책 목록 출력 ==");
        for (int i = 0; i < bookCount; i++) {
            books[i].print();
        }
    }
}
