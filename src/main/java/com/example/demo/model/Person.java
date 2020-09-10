package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

	@Id
	private Integer id;
	private String name;
	private int age;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(Integer id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Person() {
		
	}
}
