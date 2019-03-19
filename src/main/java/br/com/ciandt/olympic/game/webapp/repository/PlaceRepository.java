package br.com.ciandt.olympic.game.webapp.repository;

import br.com.ciandt.olympic.game.webapp.model.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link Place} Data Access Object.
 *
 * @author rafaelcustodio
 */
public interface PlaceRepository extends JpaRepository<Place, Long> {
}