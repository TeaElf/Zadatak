package zadatak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zadatak.domain.Profesor;

public interface ProfesorDao extends JpaRepository<Profesor, Long>{

}
