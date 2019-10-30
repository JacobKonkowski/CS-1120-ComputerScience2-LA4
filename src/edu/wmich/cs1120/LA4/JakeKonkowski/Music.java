package edu.wmich.cs1120.LA4.JakeKonkowski;

public class Music extends Multimedia {
	
	private String fileType;
	private String album;
	
	public Music(int id, String title, String publisher, String descriptor, boolean isFree, double price,
			double runtime, String fileType, String album) {
		super(id, title, publisher, descriptor, isFree, price, runtime);
		this.fileType = fileType;
		this.album = album;
	}
	
	@Override
	public double getPrice() {
		return this.priceAfterTax();
	}
	
	@Override
	public double priceAfterTax() {
		return this.price + this.price * 0.25;
	}
	
	@Override
	public String toString() {
		return "\n" +
			"Item key: " + this.id + "\n" +
			this.title + "\n" +
			"Album: " + this.album + "\n" +
			"Publisher: " + this.publisher + "\n" +
			"Description" + "\n" + this.description + "\n" +
			"Run time: " + this.runtime + "\n" +
			"Price: " + (this.isFree ? "Free" : this.getPrice())+ "\n" +
			"File Type: " + this.fileType + "\n" +
			"--------------------------" + "\n";
			
	}

}
