package zadatak.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import zadatak.domain.dto.PredmetRequestDto;
import zadatak.domain.dto.PredmetResponseDto;

public interface PredmetService {

	PredmetResponseDto save(PredmetRequestDto predmetRequestDto);
	
	PredmetResponseDto update(PredmetRequestDto predmetRequestDtp);
	
	PredmetResponseDto findById(Long id);
	
	Page<PredmetResponseDto> findAll(Predicate predicate, Pageable pageable);
	
	Boolean delete(Long id);
}
