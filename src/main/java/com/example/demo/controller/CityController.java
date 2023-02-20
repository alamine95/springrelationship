package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.requestDto.CityRequestDto;
import com.example.demo.model.City;
import com.example.demo.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	private final CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<City> addCity(@RequestBody final CityRequestDto cityRequestDto){
		City city = cityService.addCity(cityRequestDto);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<City> getCityById(@PathVariable final Long id) {
		City city = cityService.getCity(id);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<City>> getCities(){
		List<City> cities = cityService.getCities();
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<City> deleteCity(@PathVariable final Long id) {
		City city = cityService.deleteCity(id);
		return new ResponseEntity<>(city, HttpStatus.OK);
	}
	
}
