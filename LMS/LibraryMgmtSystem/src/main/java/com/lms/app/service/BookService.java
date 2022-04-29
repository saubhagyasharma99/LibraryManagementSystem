package com.lms.app.service;

import java.util.List;

import com.lms.app.entity.Book;

public interface BookService {

	

	Book saveBook(Book newBook);

	Book getBookById(Long id);

	List<Book> getAllBooks();

	void deleteBookById(Long id);

	Book updateBook(Book newBook, Long id);

	List<Book> getBooksByIsbn(String isbn);

	List<Book> getBooksByTitle(String title);

	List<Book> getBooksByAuthor(Long id);

	Book updateBookStatus(Book newBook, Long id);

}
