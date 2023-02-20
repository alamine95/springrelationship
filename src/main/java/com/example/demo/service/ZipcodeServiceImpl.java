package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.requestDto.ZipcodeRequestDto;
import com.example.demo.model.City;
import com.example.demo.model.Zipcode;
import com.example.demo.repository.ZipcodeRepository;

@Service
public class ZipcodeServiceImpl implements ZipcodeService{
	
	private final ZipcodeRepository zipcodeRepository;
	private final CityService cityService;

	@Autowired
	public ZipcodeServiceImpl(ZipcodeRepository zipcodeRepository, CityService cityService) {
		this.zipcodeRepository = zipcodeRepository;
		this.cityService = cityService;
	}

	@Transactional
	@Override
	public Zipcode addZipcode(ZipcodeRequestDto zipcodeRequestDto) {
		Zipcode zipcode = new Zipcode();
		zipcode.setName(zipcodeRequestDto.getName());
		if(zipcodeRequestDto.getCityId() == null) {
			return zipcodeRepository.save(zipcode);
		}
		City city = cityService.getCity(zipcodeRequestDto.getCityId());
		zipcode.setCity(city);
		return zipcodeRepository.save(zipcode);
	}

	@Override
	public List<Zipcode> getZipcodes() {
		return StreamSupport
				.stream(zipcodeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Zipcode getZipcode(Long zipcodeId) {
		return zipcodeRepository.findById(zipcodeId).orElseThrow(() ->
		new IllegalArgumentException("zipcode with id" + zipcodeId + "could not be found"));
	}

	@Override
	public Zipcode deleteZipcode(Long zipcodeId) {
		Zipcode zipcode = getZipcode(zipcodeId);
		zipcodeRepository.delete(zipcode);
		return zipcode;
	}

	@Override
	public Zipcode editZipcode(Long zipcodeId, ZipcodeRequestDto zipcodeRequestDto) {
		Zipcode zipcodeToEdit = getZipcode(zipcodeId);
		zipcodeToEdit.setName(zipcodeRequestDto.getName());
		if(zipcodeRequestDto.getCityId() != null) {
			return zipcodeToEdit;
		}
		City city = cityService.getCity(zipcodeRequestDto.getCityId());
		zipcodeToEdit.setCity(city);
		return zipcodeToEdit;
	}

	@Transactional
	@Override
	public Zipcode addCityToZipcode(Long zipcodeId, Long cityId) {
		Zipcode zipcode = getZipcode(zipcodeId);
		City city = cityService.getCity(cityId);
		if(Objects.nonNull(zipcode.getCity())) {
			throw new IllegalArgumentException("Zipcode already has city");
		}
		zipcode.setCity(city);
		return zipcode;
	}

	@Transactional
	@Override
	public Zipcode removeCityFromZipcode(Long zipcodLong) {
		Zipcode zipcode = getZipcode(zipcodLong);
		if(!Objects.nonNull(zipcode.getCity())) {
			throw new IllegalArgumentException("Zipcode already has city");
		}
		zipcode.setCity(null);
		return zipcode;
	}

}
