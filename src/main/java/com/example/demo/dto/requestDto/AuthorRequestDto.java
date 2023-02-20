package com.example.demo.dto.requestDto;

import lombok.Data;

@Data
public class AuthorRequestDto {

	private String name;
	private Long zipcodeId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getZipcodeId() {
		return zipcodeId;
	}
	public void setZipcodeId(Long zipcodeId) {
		this.zipcodeId = zipcodeId;
	}
}
