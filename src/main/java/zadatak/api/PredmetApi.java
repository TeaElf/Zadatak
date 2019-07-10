package zadatak.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import zadatak.dao.PredmetDao;
import zadatak.domain.Predmet;
import zadatak.domain.dto.PredmetRequestDto;
import zadatak.domain.dto.PredmetResponseDto;
import zadatak.service.PredmetService;

@RestController
@RequestMapping(value = "/predmet")
public class PredmetApi {

	private PredmetService predmetService;
	
	@Autowired
	public PredmetApi(PredmetService predmetService) {
		this.predmetService = predmetService;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PredmetResponseDto save (@RequestBody PredmetRequestDto predmet) {
		return predmetService.save(predmet);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PredmetResponseDto update (@RequestBody PredmetRequestDto predmet) {
		return predmetService.update(predmet);
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PredmetResponseDto findById (@RequestParam Long id) {
		return predmetService.findById(id);
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Page<PredmetResponseDto> findAll (@QuerydslPredicate(root = Predmet.class, bindings = PredmetDao.class) Predicate predicate, @PageableDefault(value = 20, page = 0) Pageable pageable) {
		return predmetService.findAll(predicate, pageable);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return predmetService.delete(id);
	}

}
