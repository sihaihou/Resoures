package hs.pojo;

import java.sql.Timestamp;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private String author;
	private String name;
	private Double price;
	private Timestamp pubDate;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(Double price) {
		this.price = price;
	}

	/** full constructor */
	public Book(Category category, String author, String name, Double price, Timestamp pubDate) {
		this.category = category;
		this.author = author;
		this.name = name;
		this.price = price;
		this.pubDate = pubDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Timestamp getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Timestamp pubDate) {
		this.pubDate = pubDate;
	}

}