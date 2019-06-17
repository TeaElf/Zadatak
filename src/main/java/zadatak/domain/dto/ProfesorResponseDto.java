package zadatak.domain.dto;

import java.util.List;

import zadatak.domain.Profesor;

public class ProfesorResponseDto {

	private Long id;
	
	private String ime;
	
	private String prezime;
	
	private List<PredmetResponseDto> predmeti;

	public ProfesorResponseDto() {
		super();
	}
	public ProfesorResponseDto(Profesor profesor) {
		this.id = profesor.getId();
		this.ime = profesor.getIme();
		this.prezime = profesor.getPrezime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<PredmetResponseDto> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetResponseDto> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}
