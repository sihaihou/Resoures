package hs.pojo;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private int id;
	private String name;
	private Set<Book> books = new HashSet<Book>(0);
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}
