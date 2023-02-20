package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.requestDto.CityRequestDto;
import com.example.demo.model.City;

@Service
public interface CityService {

	public City addCity(CityRequestDto cityRequestDto);
	public List<City> getCities();
	public City getCity(Long cityId);
	public City deleteCity(Long cityId);
	//public City editCity(Long cityId, CityRequestDto);
}
