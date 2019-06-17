package zadatak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zadatak.domain.Predmet;

public interface PredmetDao extends JpaRepository<Predmet, Long> {

}
