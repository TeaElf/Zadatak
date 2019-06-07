package zadatak.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import zadatak.domain.Predmet;
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
	public @ResponseBody Predmet save (@RequestBody Predmet predmet) {
		return null;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Predmet update (@RequestBody Predmet predmet) {
		return null;
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Predmet findById (@RequestParam Long id) {
		return null;
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Predmet> findAll () {
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return null;
	}

}
