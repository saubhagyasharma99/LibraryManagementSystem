package com.lms.app.entity;

import java.net.URL;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private String isbn;
	private String title;
	private String status;
	
	@ManyToMany
    @JoinTable(name = "books_authors", 
      joinColumns = @JoinColumn(name = "book_id"), 
      inverseJoinColumns = @JoinColumn(name = "author_id"))
	
	private Set<Author> authors;
	

	@OneToOne(mappedBy = "book")
	@JsonIgnore
	private Borrow borrow;
	
	public Book() {
		super();
	}

	
	
	
	public Book(long id, String isbn, String title, String status, Set<Author> authors, Borrow borrow) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.status = status;
		this.authors = authors;
		this.borrow = borrow;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getIsbn() {
		return isbn;
	}




	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Set<Author> getAuthors() {
		return authors;
	}




	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}




	public Borrow getBorrow() {
		return borrow;
	}




	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}




	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Book))
	      return false;
	    Book book = (Book) o;
	    return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title)
	        && Objects.equals(this.authors, book.authors);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.title, this.authors);
	  }

	  @Override
	  public String toString() {
	    return "Book[" + "id=" + this.id + ", title='" + this.title + "]";
	  }
	
}
