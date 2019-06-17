package zadatak.service;

import java.util.List;

import zadatak.domain.dto.PredmetRequestDto;
import zadatak.domain.dto.PredmetResponseDto;

public interface PredmetService {

	PredmetResponseDto save(PredmetRequestDto predmetRequestDto);
	
	PredmetResponseDto update(PredmetRequestDto predmetRequestDtp);
	
	PredmetResponseDto findById(Long id);
	
	List<PredmetResponseDto> findAll();
	
	Boolean delete(Long id);
}
