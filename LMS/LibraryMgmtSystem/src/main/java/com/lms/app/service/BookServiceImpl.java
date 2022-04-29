package com.lms.app.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.app.entity.Author;
import com.lms.app.entity.Book;
import com.lms.app.exception.config.BookNotFoundException;
import com.lms.app.repository.AuthorRepository;
import com.lms.app.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	
	}
	@Override
	public Book saveBook(Book newBook) {
		
		return bookRepository.save(newBook);
	}

	@Override
	public Book getBookById(Long id) {
		
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException(id));
	}

	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book newBook, Long id) {
		
		return bookRepository.findById(id)
				.map(book -> {
			    	book.setIsbn(newBook.getIsbn());
			        book.setTitle(newBook.getTitle());
			        book.setStatus(newBook.getStatus());
			        book.setAuthors(newBook.getAuthors());
			        
			        return bookRepository.save(book);
			      })
			      .orElseGet(() -> {
			        newBook.setId(id);
			        return bookRepository.save(newBook);
			      });
	}
	
	@Override
	public void deleteBookById(Long id) {
		
		bookRepository.deleteById(id);
		
	}
	@Override
	public List<Book> getBooksByIsbn(String isbn) {
		
		return bookRepository.findByIsbn(isbn)
				.orElseThrow(()-> new BookNotFoundException(isbn));
	}
	@Override
	public List<Book> getBooksByTitle(String title) {
		
		return bookRepository.findByTitle(title)
				.orElseThrow(()-> new BookNotFoundException(title));
	}
	@Override
	public List<Book> getBooksByAuthor(Long id) {
		Author author = authorRepository.findById(id)
				.orElse(new Author());
		return bookRepository.findByAuthorsIn(Set.of(author))
				.orElseThrow(()-> new BookNotFoundException(author.toString()));
	}
	
	@Override
	public Book updateBookStatus(Book newBook, Long id) {
		 //Update book status (from AVAILABLE or BORROWED and vice versa)
		return bookRepository.findById(id)
				.map(book -> {
					if(book.getStatus().equals("AVAILABLE")) {
			        book.setStatus("BORROWED");
					}
					else {
						book.setStatus("AVAILABLE");
					}
			        
			        return bookRepository.save(book);
			      })
			      .orElseGet(() -> {
			        newBook.setId(id);
			        newBook.setStatus("AVAILABLE"); 
			        return bookRepository.save(newBook);
			      });
	}
	

}
