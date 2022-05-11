package com.lms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.app.entity.Book;
import com.lms.app.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;

	@Autowired
	  public BookController(BookService bookService) {
	    this.bookService = bookService;
	  }


	  // fetch all books
	  @GetMapping("/books")
	  List<Book> all() {
	    return bookService.getAllBooks();
	  }
	  
	  // fetch books by ISBN
	  @GetMapping("/books/isbn/{isbn}")
	  List<Book> allByIsbn(@PathVariable String isbn) {
	    return bookService.getBooksByIsbn(isbn);
	  }
	  
	  // fetch books by title
	  @GetMapping("/books/title/{title}")
	  List<Book> allByTitle(@PathVariable String  title) {
	    return bookService.getBooksByTitle(title);
	  }
	  
	  // fetch books by author
	  @GetMapping("/books/author/{id}")
	  List<Book> allByAuthorId(@PathVariable Long id) {
	    return bookService.getBooksByAuthor(id);
	  }
	  
	  // save new book
	  @PostMapping("/books")
	  Book newBook(@RequestBody Book newBook) {
		newBook.setStatus("AVAILABLE");
	    return bookService.saveBook(newBook);
	  }

	  //fetch  Single item
	  
	  @GetMapping("/books/{id}")
	 Book one(@PathVariable Long id) {
	    
	    return bookService.getBookById(id);
	      
	  }

	  // update book details
	  @PutMapping("/books/{id}")
	  Book UpdateBook(@RequestBody Book newBook, @PathVariable Long id) {
	    
	    return bookService.updateBook(newBook, id);
	      
	  }
	  
	  // update book status
	  // but suitable to edit invalid status of book
	  @PutMapping("/books/status/{id}")
	  Book UpdateBookStatus(@RequestBody Book newBook, @PathVariable Long id ) {
	    
	    return bookService.updateBookStatus(newBook, id);
	      
	  }

	  @DeleteMapping("/books/{id}")
	  void deleteBook(@PathVariable Long id) {
	    bookService.deleteBookById(id);
	  }
}
