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
	public @ResponseBody List<PredmetResponseDto> findAll (@QuerydslPredicate(root = Predmet.class, bindings = PredmetDao.class) Predicate predicate) {
		return predmetService.findAll(predicate);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return predmetService.delete(id);
	}

}
