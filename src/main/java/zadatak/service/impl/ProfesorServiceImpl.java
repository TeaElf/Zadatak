package zadatak.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import zadatak.dao.ProfesorDao;
import zadatak.domain.Profesor;
import zadatak.domain.dto.ProfesorRequestDto;
import zadatak.domain.dto.ProfesorResponseDto;
import zadatak.exceptions.ResourceNotFoundException;
import zadatak.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	private ProfesorDao profesorDao;
	
	@Autowired
	public ProfesorServiceImpl(ProfesorDao profesorDao) {
		this.profesorDao = profesorDao;
	}
	@Override
	public ProfesorResponseDto save(ProfesorRequestDto profesorRequestDto) {
		Profesor profesor = new Profesor();
		profesor.setIme(profesorRequestDto.getIme());
		profesor.setPrezime(profesorRequestDto.getPrezime());
		profesorDao.save(profesor);
		ProfesorResponseDto response = new ProfesorResponseDto(profesor);
		return response;
	}

	@Override
	public ProfesorResponseDto update(ProfesorRequestDto profesorRequestDto) {
		Optional<Profesor> opProfesor = profesorDao.findById(profesorRequestDto.getId());
		if(!opProfesor.isPresent()) {
			throw new ResourceNotFoundException("Profesor", "id", profesorRequestDto.getId());
		}
		Profesor profesor = opProfesor.get();
		profesor.setIme(profesorRequestDto.getIme());
		profesor.setPrezime(profesorRequestDto.getPrezime());
		profesorDao.save(profesor);
		ProfesorResponseDto response = new ProfesorResponseDto(profesor);
		return response ;
	}

	@Override
	public ProfesorResponseDto findById(Long id) {
		Optional<Profesor> opProfesor = profesorDao.findById(id);
		if(!opProfesor.isPresent()) {
			throw new ResourceNotFoundException("Profesor", "id", id);
		}
		Profesor profesor = opProfesor.get();
		ProfesorResponseDto response = new ProfesorResponseDto(profesor);
		return response;
	}

	@Override
	public Page<ProfesorResponseDto> findAll(Predicate predicate, Pageable pageable) {
		Page<Profesor> profesors = profesorDao.findAll(predicate, pageable);
		return new PageImpl<>(profesors.stream().map(ProfesorResponseDto::new).collect(Collectors.toList()), pageable, profesors.getTotalElements());
	}

	@Override
	public Boolean delete(Long id) {
		if(profesorDao.existsById(id)) {
			profesorDao.deleteById(id);
			return true;
		}
		return false;
		
	}

}
