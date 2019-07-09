package zadatak.service;

import java.util.List;

import com.querydsl.core.types.Predicate;

import zadatak.domain.dto.ProfesorRequestDto;
import zadatak.domain.dto.ProfesorResponseDto;


public interface ProfesorService {

	ProfesorResponseDto save(ProfesorRequestDto profesorRequestDto);
	
	ProfesorResponseDto update(ProfesorRequestDto profesorRequestDtp);
	
	ProfesorResponseDto findById(Long id);
	
	List<ProfesorResponseDto> findAll(Predicate predicate);
	
	Boolean delete(Long id);
	
}
