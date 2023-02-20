package com.example.demo.dto.requestDto;

import lombok.Data;

@Data
public class ZipcodeRequestDto {

	private String name;
	private Long cityId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
}
