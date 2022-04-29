package com.lms.app.repository;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.app.entity.Author;
import com.lms.app.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	
	public Optional< List<Book>> findByIsbn(String isbn);
	
	public Optional<List<Book>> findByTitle(String title);
	
	public Optional<List<Book>> findByAuthorsIn(Set<Author> authors);
	
	
}
