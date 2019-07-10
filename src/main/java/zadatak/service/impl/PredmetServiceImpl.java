package zadatak.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import zadatak.dao.PredmetDao;
import zadatak.dao.ProfesorDao;
import zadatak.domain.Predmet;
import zadatak.domain.Profesor;
import zadatak.domain.dto.PredmetRequestDto;
import zadatak.domain.dto.PredmetResponseDto;
import zadatak.exceptions.ResourceNotFoundException;
import zadatak.service.PredmetService;

@Service
public class PredmetServiceImpl implements PredmetService {
	
	private PredmetDao predmetDao;
	
	private ProfesorDao profesorDao;
	
	@Autowired
	public PredmetServiceImpl(PredmetDao predmetDao, ProfesorDao profesorDao) {
		this.predmetDao = predmetDao;
		this.profesorDao = profesorDao;
	}

	@Override
	public PredmetResponseDto save(PredmetRequestDto predmetRequestDto) {
		Predmet predmet = new Predmet();
		predmet.setId(predmetRequestDto.getId());
		predmet.setNaziv(predmetRequestDto.getNaziv());
		if(predmetRequestDto.getProfesorId()!=null) {
			
			if (!profesorDao.existsById(predmetRequestDto.getProfesorId()))
				throw new ResourceNotFoundException("Profesor","id", predmetRequestDto.getProfesorId());
			
			Profesor profesor = profesorDao.getOne(predmetRequestDto.getProfesorId());
			predmet.setProfesor(profesor);
		}
		predmetDao.save(predmet);
		PredmetResponseDto response = new PredmetResponseDto(predmet);
		return response;
	}

	@Override
	public PredmetResponseDto update(PredmetRequestDto predmetRequestDto) {
		if(!predmetDao.existsById(predmetRequestDto.getId())) {
			throw new ResourceNotFoundException("Predmet", "id", predmetRequestDto.getId());
		}
		Predmet predmet = predmetDao.getOne(predmetRequestDto.getId());
		predmet.setNaziv(predmetRequestDto.getNaziv());
		
		predmetDao.save(predmet);
		PredmetResponseDto response = new PredmetResponseDto(predmet);
		return response;
	}

	@Override
	public PredmetResponseDto findById(Long id) {
		Optional<Predmet> optPredmet = predmetDao.findById(id);
		Predmet predmet = null;
		if(!optPredmet.isPresent()) {
			throw new ResourceNotFoundException("Predmet", "id", id);
		}
		predmet = optPredmet.get();
		PredmetResponseDto response = new PredmetResponseDto(predmet);
		return response;
	}

	@Override
	public Page<PredmetResponseDto> findAll(Predicate predicate, Pageable pageable) {
		Page<Predmet> predmeti = predmetDao.findAll(predicate, pageable);
		return new PageImpl<>(predmeti.stream().map(PredmetResponseDto::new).collect(Collectors.toList()), pageable, predmeti.getTotalElements());
	}

	@Override
	public Boolean delete(Long id) {
		if(predmetDao.existsById(id)) {
			predmetDao.deleteById(id);
			return true;
		}
		return false;
	}

}
