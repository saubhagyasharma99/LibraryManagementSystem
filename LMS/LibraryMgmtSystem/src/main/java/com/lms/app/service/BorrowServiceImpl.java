package com.lms.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.app.entity.Borrow;
import com.lms.app.exception.config.BorrowNotFoundException;
import com.lms.app.repository.BorrowRepository;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService{
	
	@Autowired
	BorrowRepository borrowRepository;

	@Autowired
	BookService bookService;
	
	@Override
	public List<Borrow> getAllBorrows() {
		
		return borrowRepository.findAll();
	}

	@Override
	public Borrow getBorrowById(long id) {
		
		return borrowRepository.findById(id)
				.orElseThrow(() -> new BorrowNotFoundException(id));
	
	}

	@Override
	public Borrow addNewBorrow(Borrow borrow) {
		
		return borrowRepository.save(borrow);
	}

	@Override
	public Borrow updateBorrow(Borrow borrow, long id) {
		
		return borrowRepository.findById(id)
				.map(b -> {
			    	b.setUsername(borrow.getUsername());
			        b.setDatetime(borrow.getDatetime());
			        b.setBook(bookService.getBookById(borrow.getBook().getId()));
			        
			        return borrowRepository.save(b);
			      })
			      .orElseGet(() -> {
			        borrow.setId(id);
			        return borrowRepository.save(borrow);
			      });
	}

	@Override
	public void deleteBorrow(long id) {
		
		 borrowRepository.deleteById(id);
	}

}
