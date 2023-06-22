package com.example.class1spring;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "quotes")
public class QuoteEntity {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "text")
	private String quoteText;

	@Column(name = "author")
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuoteText() {
		return quoteText;
	}

	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
