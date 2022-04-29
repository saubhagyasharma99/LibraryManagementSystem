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
import com.lms.app.entity.Borrow;
import com.lms.app.exception.config.BookNotAvailableException;
import com.lms.app.service.BookService;
import com.lms.app.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
	
	
	@Autowired
	BorrowService borrowService;
	
	

	@Autowired
	BookService bookService;
	
	@GetMapping
	public List<Borrow> getBorrowedBooks(){
		return borrowService.getAllBorrows();
	}
	
	
	@GetMapping("/{id}")
	public Borrow getSingleBorrow(@PathVariable("id") long id) {
		return borrowService.getBorrowById( id);
	}
	
	@PostMapping
	public Borrow newBorrow(@RequestBody Borrow borrow) {
		
		Book book = bookService.getBookById(borrow.getBook().getId());
		if(book==null || book.getStatus().equals("BORROWED")) {
			throw new BookNotAvailableException("Book not available!");
		}
			
			book.setStatus("BORROWED");
			borrow.setBook(book);
			return borrowService.addNewBorrow(borrow);	
	}
	
	@PutMapping("/{id}")
	public Borrow reviceBorrow(@RequestBody Borrow borrow, @PathVariable("id") long id) {
		
		//if book has been updated form borrowed
		Book newBook = bookService.getBookById(borrow.getBook().getId());
		if(newBook==null || newBook.getStatus().equals("BORROWED")) {
			throw new BookNotAvailableException("Book not available!");
		}
		newBook.setStatus("BORROWED");
		
		Borrow oldBorrow = borrowService.getBorrowById(id);
		Book borrowed  = oldBorrow.getBook();
		// change book from borrowed
		borrowed.setStatus("AVAILABLE");
		bookService.updateBook(borrowed, borrowed.getId());
		bookService.updateBook(newBook, newBook.getId());
		borrow.setBook(newBook);
		return borrowService.updateBorrow(borrow, id);
	}
	
	@DeleteMapping("/{id}")
	public void rempveBorrow(@PathVariable("id") long id) {
		Borrow borrow = borrowService.getBorrowById(id);
		Book b = borrow.getBook();
		b.setStatus("AVAILABLE");
		bookService.updateBook(b, b.getId());
		borrowService.deleteBorrow(id);
	}

}
