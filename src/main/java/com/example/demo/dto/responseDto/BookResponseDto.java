package com.example.demo.dto.responseDto;

import java.util.List;

import lombok.Data;

@Data
public class BookResponseDto {

	private Long id;
	private String name;
	private List<String> authorNames;
	private String categoryName;
	
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
	public List<String> getAuthorNames() {
		return authorNames;
	}
	public void setAuthorNames(List<String> authorNames) {
		this.authorNames = authorNames;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
