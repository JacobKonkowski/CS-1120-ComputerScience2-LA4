package edu.wmich.cs1120.LA4.JakeKonkowski;

import java.util.Arrays;

public class Book extends Item implements IPromotion {
	
	private int pages;
	private String writerName;
	private String ISBN;
	private String[] languages;

	public Book(int id, String title, String publisher, String descriptor, boolean isFree,
			double price, int pages, String writerName, String ISBN, String[] languages) {
		super(id, title, publisher, descriptor, isFree, price);
		this.pages = pages;
		this.writerName = writerName;
		this.ISBN = ISBN;
		this.languages = languages;
	}
	
	@Override
	public double getPrice() {
		return salesPromotion();
	}

	@Override
	public double priceAfterTax() {
		return this.getPrice() + this.getPrice() * 0.2;
	}

	@Override
	public double salesPromotion() {
		return this.price - (this.price * 0.8);
	}
	
	@Override
	public String toString() {
		return "\n" +
			"Item key: " + this.id + "\n" +
			this.title + "\n" +
			"Publisher: " + this.publisher + "\n" +
			"Description" + "\n" + this.description + "\n" +
			"Price: " + (this.isFree ? "Free" : this.priceAfterTax())+ "\n" +
			"ISBN: " + this.ISBN + "\n" +
			"Pages: " + this.pages + "\n" +
			"Writer Name: " + this.writerName + "\n" +
			"Languages: " + Arrays.toString(this.languages) + "\n" +
			"--------------------------" + "\n";
	}

}
