package br.com.ciandt.olympic.game.webapp.repository;

import br.com.ciandt.olympic.game.webapp.model.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link Sport} Data Access Object.
 *
 * @author rafaelcustodio
 */
public interface SportRepository extends JpaRepository<Sport, Long> {
}