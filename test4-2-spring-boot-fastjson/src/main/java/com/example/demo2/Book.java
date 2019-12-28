package com.example.demo2;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Book {

	public String name;
    public String author;
    public Float price;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;
    public int id;
    
    
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

}
