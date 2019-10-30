package edu.wmich.cs1120.LA4.JakeKonkowski;

public class User {

	private int id;
	private String username;
	private String password;
	private Item[] library = new Item[10];
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public void addItemToTheLibrary(Item item) {
		
		if (library[library.length - 1] != null) {
			Item[] newArray = new Item[library.length * 2];
			System.arraycopy(this.library, 0, newArray, 0, this.library.length);
			this.library = newArray;
		}
		
		for (int i = 0; i < this.library.length; i++) {
			
			if (this.library[i] == null) {
				this.library[i] = item;
				return;
			}
			
		}
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Item[] getLibrary() {
		return library;
	}
	
	public boolean hasItem(Item item) {
		boolean has = false;
		
		for (int i = 0; i < this.library.length; i++) {
			if (item.equals(this.library[i])) {
				has = true;
			}
		}
		
		return has;
	}
	
}
