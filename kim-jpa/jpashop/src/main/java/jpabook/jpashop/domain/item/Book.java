package jpabook.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jpabook.jpashop.dto.BookForm;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B") // 싱글테이블 전략 시 저장할 때의 식별값
@Getter @Setter
public class Book extends Item {

	private String author;

	private String isbn;

	// == 생성 메서드 == //
	public static Book createBook(BookForm bookForm) {
		Book book = new Book();
		book.setName(bookForm.getName());
		book.setPrice(bookForm.getPrice());
		book.setStock(bookForm.getStock());
		book.setAuthor(bookForm.getAuthor());
		book.setIsbn(bookForm.getIsbn());

		return book;
	}

	// == to Dto == //
	public BookForm toForm() {
		BookForm bookForm = new BookForm();
		bookForm.setName(super.getName());
		bookForm.setPrice(super.getPrice());
		bookForm.setStock(super.getStock());
		bookForm.setAuthor(author);
		bookForm.setIsbn(isbn);

		return bookForm;
	}
}
