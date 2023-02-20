package com.example.demo.controller;

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

import com.example.demo.dto.requestDto.CategoryRequestDto;
import com.example.demo.dto.responseDto.CategoryResponseDto;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<CategoryResponseDto> addCategory(
			@RequestBody final CategoryRequestDto categoryRequestDto) {
		CategoryResponseDto categoryResponseDto = categoryService.addCategory(categoryRequestDto);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(id);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable final Long id){
		CategoryResponseDto categoryResponseDto = categoryService.deleteCategory(id);
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<CategoryResponseDto> editCategory(
			@RequestBody final CategoryRequestDto categoryRequestDto,
			@PathVariable final Long id){
		CategoryResponseDto categResponseDto = categoryService.aditCategory(id, categoryRequestDto);
		return new ResponseEntity<>(categResponseDto, HttpStatus.OK);
	}

}
