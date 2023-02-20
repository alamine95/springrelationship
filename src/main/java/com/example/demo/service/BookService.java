package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.requestDto.BookRequestDto;
import com.example.demo.dto.responseDto.BookResponseDto;
import com.example.demo.model.Book;

@Service
public interface BookService {

	public BookResponseDto addBook(BookRequestDto bookRequestDto);
	public BookResponseDto getBookById(Long bookId);
	public Book getBook(Long bookId);
	public List<BookResponseDto> getBooks();
	public BookResponseDto deleteBook(Long bookId);
	public BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto);
	public BookResponseDto addAuthorToBook(Long bookId, Long authorId);
	public BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId);
	public BookResponseDto addCategoryToBook(Long bookId, Long categoryId);
	public BookResponseDto removeCategoryFromBook(Long bookId, Long categoryId);
}
