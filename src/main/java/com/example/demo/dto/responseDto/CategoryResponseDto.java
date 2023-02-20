package com.example.demo.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryResponseDto {

	private Long id;
	private String name;
	private List<String> bookNames;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getBookNames() {
		return bookNames;
	}
	public void setBookNames(List<String> bookNames) {
		this.bookNames = bookNames;
	}
}
