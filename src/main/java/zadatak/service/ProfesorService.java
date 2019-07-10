package zadatak.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import zadatak.domain.dto.ProfesorRequestDto;
import zadatak.domain.dto.ProfesorResponseDto;


public interface ProfesorService {

	ProfesorResponseDto save(ProfesorRequestDto profesorRequestDto);
	
	ProfesorResponseDto update(ProfesorRequestDto profesorRequestDtp);
	
	ProfesorResponseDto findById(Long id);
	
	Page<ProfesorResponseDto> findAll(Predicate predicate, Pageable pageable);
	
	Boolean delete(Long id);
	
}
