package com.example.demo.dto.requestDto;

import lombok.Data;

@Data
public class CategoryRequestDto {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
