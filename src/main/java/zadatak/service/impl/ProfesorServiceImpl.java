package zadatak.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zadatak.dao.ProfesorDao;
import zadatak.domain.Profesor;
import zadatak.domain.dto.ProfesorRequestDto;
import zadatak.domain.dto.ProfesorResponseDto;
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
			//TODO exception
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
			//TODO Exception
		}
		Profesor profesor = opProfesor.get();
		ProfesorResponseDto response = new ProfesorResponseDto(profesor);
		return response;
	}

	@Override
	public List<ProfesorResponseDto> findAll() {
		List<Profesor> profesors = profesorDao.findAll();
		List<ProfesorResponseDto> response = new ArrayList<ProfesorResponseDto>();
		profesors.forEach(profesor -> response.add(new ProfesorResponseDto(profesor)));
		return response;
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
