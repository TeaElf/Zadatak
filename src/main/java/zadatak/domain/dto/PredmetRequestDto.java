package zadatak.domain.dto;
;

public class PredmetRequestDto {

	private Long id;
	
	private String naziv;	
	
	private Long profesorId;

	public PredmetRequestDto() {
		super();
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

	public Long getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}
	
	
	
}
