package com.lms.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.app.entity.Author;
import com.lms.app.entity.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Optional<List<Author>> findByName(String name);
	
	public Optional<Set<Author>> findByBooksIn(Set<Book> books);
	
}
