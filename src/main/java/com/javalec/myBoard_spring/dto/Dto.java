package com.javalec.myBoard_spring.dto;

import java.sql.Timestamp;

public class Dto {

	int bId;
	String name;
	String title;
	String content;
	Timestamp date;
	int hit;

	public Dto() {
		super();
	}
	public Dto(int bId, String name, String title, String content, Timestamp date, int hit) {
		super();
		this.bId = bId;
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
		this.hit = hit;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	
}
