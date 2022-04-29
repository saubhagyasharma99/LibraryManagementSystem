package com.lms.app.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="author_id")
	private long id;
	private String name;
	
	
	@ManyToMany(mappedBy = "authors")
	@JsonIgnore
	private Set<Book> books;
	
	public Author() {
		super();
	}
	
	

	public Author(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public Author(long id, String name, Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Author))
	      return false;
	    Author author = (Author) o;
	    return Objects.equals(this.id, author.id) && Objects.equals(this.name, author.name);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.name);
	  }

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

	

}