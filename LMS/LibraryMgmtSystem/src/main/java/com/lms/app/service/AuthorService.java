package com.lms.app.service;


import java.util.List;

import com.lms.app.entity.Author;

public interface AuthorService {

	List<Author> getAll();

	Author saveAuthor(Author newAuthor);

	Author getAuthorById(Long id);

	void deleteAuthorById(Long id);

	Author updateAuthor(Author newAuthor, Long id);

}
