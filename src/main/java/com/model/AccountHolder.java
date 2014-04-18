package com.model;


public class AccountHolder {
	
	private String name;
	private int id;
	
	
	public AccountHolder(){
		
	}
	
	
	public AccountHolder(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
