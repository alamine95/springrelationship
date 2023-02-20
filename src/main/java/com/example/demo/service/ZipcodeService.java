package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.requestDto.ZipcodeRequestDto;
import com.example.demo.model.Zipcode;

@Service
public interface ZipcodeService {

	public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto);
	public List<Zipcode> getZipcodes();
	public Zipcode getZipcode(Long zipcodeId);
	public Zipcode deleteZipcode(Long zipcodeId);
	public Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto);
	public Zipcode addCityToZipcode(Long zipcodeId, Long cityId);
	public Zipcode removeCityFromZipcode(Long zipcodLong);
}
