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

import zadatak.domain.Profesor;
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
	public @ResponseBody Profesor save (@RequestBody Profesor profesor) {
		return null;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Profesor update (@RequestBody Profesor profesor) {
		return null;
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Profesor findById (@RequestParam Long id) {
		return null;
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Profesor> findAll () {
		return null;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return null;
	}
}
