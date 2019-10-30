package edu.wmich.cs1120.LA4.JakeKonkowski;

public class Movie extends Multimedia implements IPromotion {
	
	private String audioLanguage;
	private String category;
	
	public Movie(int id, String title, String publisher, String description, boolean isFree, double price,
			double runtime, String audioLanguage, String category) {
		super(id, title, publisher, description, isFree, price, runtime);
		this.audioLanguage = audioLanguage;
		this.category = category;
	}

	@Override
	public double getPrice() {
		return salesPromotion();
	}

	@Override
	public double salesPromotion() {
		return this.price - (this.price * 0.5);
	}
	
	@Override
	public String toString() {
		return "\n" +
			"Item key: " + this.id + "\n" +
			this.title + "\n" +
			"Publisher: " + this.publisher + "\n" +
			"Description" + "\n" + this.description + "\n" +
			"Run time: " + this.runtime + "\n" +
			"Price: " + (this.isFree ? "Free" : this.priceAfterTax())+ "\n" +
			"Category: " + this.category + "\n" +
			"Audio language: " + this.audioLanguage +
			"--------------------------" + "\n";
	}

}
