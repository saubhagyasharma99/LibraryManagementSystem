package com.lms.app.service;

import java.util.List;

import com.lms.app.entity.Borrow;

public interface BorrowService {

	List<Borrow> getAllBorrows();

	Borrow getBorrowById(long id);

	Borrow addNewBorrow(Borrow borrow);

	Borrow updateBorrow(Borrow borrow, long id);

	void deleteBorrow(long id);

}
