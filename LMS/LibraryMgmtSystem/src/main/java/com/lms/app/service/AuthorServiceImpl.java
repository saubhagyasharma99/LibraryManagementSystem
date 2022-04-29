package com.lms.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lms.app.entity.Author;
import com.lms.app.exception.config.AuthorNotFoundException;
import com.lms.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{
	
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> getAll() {
		
		return authorRepository.findAll();
	}

	@Override
	public Author saveAuthor(Author newAuthor) {
		
		return authorRepository.save(newAuthor);
	}

	@Override
	public Author getAuthorById(Long id) {
		
		return authorRepository.findById(id)
		.orElseThrow(() -> new AuthorNotFoundException(id));
	}
	
	

	@Override
	public void deleteAuthorById(Long id) {
		
		authorRepository.deleteById(id);
	}

	@Override
	public Author updateAuthor(Author newAuthor, Long id) {
		
		return authorRepository.findById(id)
				.map(book -> {
			    	book.setName(newAuthor.getName());
			        
			        return authorRepository.save(book);
			      })
			      .orElseGet(() -> {
			        newAuthor.setId(id);
			        return authorRepository.save(newAuthor);
			      });
	}

	

}
