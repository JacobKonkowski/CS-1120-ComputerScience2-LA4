package edu.wmich.cs1120.LA4.JakeKonkowski;

public abstract class Item {
	
	protected int id;
	protected String title;
	protected String publisher;
	protected String description;
	protected boolean isFree;
	protected double price;

	public Item() {

	}

	public Item(int id, String title, String publisher, String descriptor, boolean isFree, double price) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.description = descriptor;
		this.isFree = isFree;
		this.price = price;
	}

	abstract double priceAfterTax();
	public abstract String toString();

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getDescriptor() {
		return description;
	}

	public boolean isFree() {
		return isFree;
	}

	public double getPrice() {
		return price;
	}
	
}
