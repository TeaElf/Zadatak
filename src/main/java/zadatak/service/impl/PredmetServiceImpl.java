package zadatak.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import zadatak.dao.PredmetDao;
import zadatak.domain.Predmet;
import zadatak.domain.dto.PredmetRequestDto;
import zadatak.domain.dto.PredmetResponseDto;
import zadatak.service.PredmetService;

@Service
public class PredmetServiceImpl implements PredmetService {
	
	private PredmetDao predmetDao;
	
	@Autowired
	public PredmetServiceImpl(PredmetDao predmetDao) {
		this.predmetDao = predmetDao;
	}

	@Override
	public PredmetResponseDto save(PredmetRequestDto predmetRequestDto) {
		Predmet predmet = new Predmet();
		predmet.setId(predmetRequestDto.getId());
		predmet.setNaziv(predmetRequestDto.getNaziv());
		predmetDao.save(predmet);
		PredmetResponseDto response = new PredmetResponseDto(predmet);
		return response;
	}

	@Override
	public PredmetResponseDto update(PredmetRequestDto predmetRequestDto) {
		if(!predmetDao.existsById(predmetRequestDto.getId())) {
			//TODO exception
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
			//TODO Exception
		}
		predmet = optPredmet.get();
		PredmetResponseDto response = new PredmetResponseDto(predmet);
		return response;
	}

	@Override
	public List<PredmetResponseDto> findAll(Predicate predicate) {
		List<Predmet> predmeti = predmetDao.findAll();
		List<PredmetResponseDto> responses = new ArrayList<PredmetResponseDto>();
		for(Predmet predmet: predmeti) {
			PredmetResponseDto response = new PredmetResponseDto(predmet);
			responses.add(response);
		}
		return responses;
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
