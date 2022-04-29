package com.lms.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.app.controller.AuthorController;
import com.lms.app.controller.BookController;
import com.lms.app.controller.BorrowController;

@SpringBootTest
class LibraryMgmtSystemApplicationTests {
	
	@Autowired
	BookController bookController;

	@Autowired
	AuthorController authorController;
	
	@Autowired
	BorrowController borrowController;
	
	
	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(authorController).isNotNull();
		assertThat(borrowController).isNotNull();
	}

}
