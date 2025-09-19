package com.project.gamingclub.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="members")


public class members {
@Id
private String id;
private String name;
private double balance;
private String phone;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public members(String name, double balance, String phone) {
	super();
	this.name = name;
	this.balance = balance;
	this.phone = phone;
}


}

