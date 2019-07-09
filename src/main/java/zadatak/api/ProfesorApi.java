package zadatak.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import zadatak.dao.ProfesorDao;
import zadatak.domain.Profesor;
import zadatak.domain.dto.ProfesorRequestDto;
import zadatak.domain.dto.ProfesorResponseDto;
import zadatak.service.ProfesorService;

@RestController
@RequestMapping(value = "/profesor")
public class ProfesorApi {

	private ProfesorService profesorService;
	
	@Autowired
	public ProfesorApi(ProfesorService profesorService) {
		this.profesorService = profesorService;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProfesorResponseDto save (@RequestBody ProfesorRequestDto profesor) {
		return profesorService.save(profesor);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProfesorResponseDto update (@RequestBody ProfesorRequestDto profesor) {
		return profesorService.update(profesor);
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProfesorResponseDto findById (@RequestParam Long id) {
		return profesorService.findById(id);
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProfesorResponseDto> findAll (@QuerydslPredicate(root = Profesor.class, bindings = ProfesorDao.class) Predicate predicate) {
		return profesorService.findAll(predicate);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return profesorService.delete(id);
	}
}
