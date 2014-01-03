package com.tmg.fuse.poc;
public class Account {

	private String Name;
	private String ID;
	
	public Account(){
		
	}

	
	
	public Account(String name, String iD) {
		super();
		Name = name;
		ID = iD;
	}



	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
	
	
}