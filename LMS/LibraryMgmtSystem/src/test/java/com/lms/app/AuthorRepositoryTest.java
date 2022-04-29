package com.lms.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.app.entity.Author;
import com.lms.app.repository.AuthorRepository;

@SpringBootTest
public class AuthorRepositoryTest {

	
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Test
	void isAuthorExistById() {
		Author author = new Author();
		author.setName("John");
		
		Author returnedAuthor = authorRepository.save(author);
//		System.out.println(author.toString());
//		Author returned = authorRepository.getById(author.getId());
//		System.out.println(returnedAuthor.toString());
		Boolean actualResult = returnedAuthor.equals(author);
		
		assertThat(actualResult).isTrue();
	}
	
	@AfterEach
	void tearDown() {
		authorRepository.deleteAll();
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Testing repo..");
	}
	
}
