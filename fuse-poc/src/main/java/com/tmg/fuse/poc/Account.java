package com.tmg.fuse.poc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Account")
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//@XmlElement(name = "name", required = true)
	private String name;
	//@XmlElement(name = "accountID", required = true)
	private String accountID;
	
	public Account(){	
		
	}

	
	public Account(String name, String id) {
		super();
		this.name = name;
		this.accountID = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String id) {
		accountID = id;
	}


	@Override
	public String toString() {
		return "Account [name=" + name + ", accountId=" + accountID + "]";
	}
	
	
	
	
}