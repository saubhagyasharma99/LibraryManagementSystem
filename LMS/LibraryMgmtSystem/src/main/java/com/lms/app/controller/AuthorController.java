package com.lms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.app.entity.Author;
import com.lms.app.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping
	  public List<Author> all() {
	    return authorService.getAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping
	  public ResponseEntity<Author> newAuthor(@RequestBody Author newAuthor) {
	    return new ResponseEntity<Author> (authorService.saveAuthor(newAuthor), HttpStatus.CREATED);
	  }

	  // Single item
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<Author> GetAuthor(@PathVariable Long id) {
	    
	    return new ResponseEntity<Author> (authorService.getAuthorById(id), HttpStatus.OK);
	      
	  }

	  @PutMapping("/{id}")
	  public Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {
	    
	    return authorService.updateAuthor(newAuthor, id);
	      
	  }

	  @DeleteMapping("/{id}")
	  public void deleteAuthor(@PathVariable Long id) {
	    authorService.deleteAuthorById(id);
	  }
	

}
