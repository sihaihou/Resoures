package hs.pojo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.junit.runners.Parameterized.Parameters;
//Entity��ʾ��Ҫ�־û��� ʵ����
@Entity
//ʵ���� ����Ӧ�ı�
@Table(name="book")
//���������
@FilterDef(name="studentFilter",parameters={@ParamDef(name="id",type="integer")})
//���ù�����
@Filter(name="studentFilter",condition="id<:id")
public class Book {
	//����id
	@Id 
	//�������ɲ���
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//����ָ������
	@Column
	private String name;
	private double price;
	private String author;
	private Date pubDate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", pubDate=" + pubDate
				+ "]";
	}
}