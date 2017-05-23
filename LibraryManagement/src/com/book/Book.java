package com.book;

public class Book {
    public int id;
    public String name;
    public String type;
    public float price;
    public String publishingHouse;
    public String author;
    public int bookCount;
    public float dayMoney;
    public Book(){}
    public Book(int id,String name,String type,float price,String publishingHouse,String author,int bookCount,float dayMoney)
    {
    	this.id=id;
    	this.name=name;
    	this.type=type;
    	this.price=price;
    	this.publishingHouse=publishingHouse;
    	this.author=author;
    	this.bookCount=bookCount;
    	this.dayMoney=dayMoney;
    }
}
