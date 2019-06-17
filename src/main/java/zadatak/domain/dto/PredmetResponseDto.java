package zadatak.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import zadatak.domain.Predmet;

@JsonInclude(Include.NON_NULL)
public class PredmetResponseDto {

	private Long id;
	
	private String naziv;	
	
	private ProfesorResponseDto profesor;

	public PredmetResponseDto() {
		super();
	}

	public PredmetResponseDto(Predmet predmet) {
		this.id =predmet.getId();
		this.naziv = predmet.getNaziv();
		if(predmet.getProfesor()!=null)
			this.profesor = new ProfesorResponseDto(predmet.getProfesor());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ProfesorResponseDto getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorResponseDto profesor) {
		this.profesor = profesor;
	}

}
