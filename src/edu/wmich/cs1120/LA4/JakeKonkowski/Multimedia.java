package edu.wmich.cs1120.LA4.JakeKonkowski;

public class Multimedia extends Item {
	
	protected boolean isPlay;
	protected double runtime;

	public Multimedia(int id, String title, String publisher, String descriptor, boolean isFree, double price,
			double runtime) {
		super(id, title, publisher, descriptor, isFree, price);
		this.isPlay = false;
		this.runtime = runtime;
	}
	
	public boolean Play() {
		return this.isPlay;
	}

	@Override
	public double priceAfterTax() {
		return this.getPrice() + this.getPrice() * 0.25;
	}

	@Override
	public String toString() {
		return "************************************" + "\n" +
			"Item key: " + this.id + "\n" +
			this.title + "\n" +
			"Publisher: " + this.publisher + "\n" +
			"Description" + "\n" + this.description + "\n" +
			"Run time: " + this.runtime + "\n" +
			"Price: " + (this.isFree ? "Free" : this.priceAfterTax()) + 
			"--------------------------" + "\n";
	}

}
