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

import com.example.demo.dto.requestDto.ZipcodeRequestDto;
import com.example.demo.model.Zipcode;
import com.example.demo.service.ZipcodeService;

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {

	private final ZipcodeService zipcodeService;

	@Autowired
	public ZipcodeController(ZipcodeService zipcodeService) {
		this.zipcodeService = zipcodeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Zipcode> addZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto){
		Zipcode zipcode = zipcodeService.addZipcode(zipcodeRequestDto);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Zipcode> getZipcode(@PathVariable final Long id){
		Zipcode zipcode = zipcodeService.getZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Zipcode>> getZipcodes() {
		List<Zipcode> zipcodes = zipcodeService.getZipcodes();
		return new ResponseEntity<>(zipcodes, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Zipcode> deleteZipcode(@PathVariable final Long id){
		Zipcode zipcode = zipcodeService.deleteZipcode(id);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<Zipcode> editZipcode(@RequestBody final ZipcodeRequestDto zipcodeRequestDto,
												@PathVariable final Long id){
		Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@PostMapping("/addCity/{cityId}/toZipcode/{zipcodeId}")
	public ResponseEntity<Zipcode> addCity(@PathVariable final Long cityId,
											@PathVariable final Long zipcodeId) {
		Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}
	
	@PostMapping("/deleteCity/{zipcodeId}")
	public ResponseEntity<Zipcode> deleteCity(@PathVariable final Long zipcodeId){
		Zipcode zipcode = zipcodeService.removeCityFromZipcode(zipcodeId);
		return new ResponseEntity<>(zipcode, HttpStatus.OK);
	}				
	
}
