package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.requestDto.CategoryRequestDto;
import com.example.demo.dto.responseDto.CategoryResponseDto;
import com.example.demo.model.Category;

@Service
public interface CategoryService {

	public Category getCategory(Long categoryId);
	public CategoryResponseDto addCategory(CategoryRequestDto categoryRequestDto);
	public CategoryResponseDto getCategoryById(Long categoryId);
	public List<CategoryResponseDto> getCategories();
	public CategoryResponseDto deleteCategory(Long categoryId);
	public CategoryResponseDto aditCategory(Long categoryId, CategoryRequestDto categoryRequestDto);
}
