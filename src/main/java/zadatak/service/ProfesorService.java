package zadatak.service;

import java.util.List;

import zadatak.domain.dto.ProfesorRequestDto;
import zadatak.domain.dto.ProfesorResponseDto;


public interface ProfesorService {

	ProfesorResponseDto save(ProfesorRequestDto profesorRequestDto);
	
	ProfesorResponseDto update(ProfesorRequestDto profesorRequestDtp);
	
	ProfesorResponseDto findById(Long id);
	
	List<ProfesorResponseDto> findAll();
	
	Boolean delete(Long id);
	
}
