package hs.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Entity��ʾ��Ҫ�־û��� ʵ����
@Entity
//ʵ���� ����Ӧ�ı�
@Table(name="t_book")
public class Book {
	//����id
	@Id 
	//�������ɲ���
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//����ָ������
	@Column(name="����")
	private String name;
	private double price;
	private String author;
	private Date pubDate;
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
}
