package br.com.ciandt.olympic.game.webapp.repository;

import br.com.ciandt.olympic.game.webapp.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link Country} Data Access Object.
 *
 * @author rafaelcustodio
 */
public interface CountryRepository extends JpaRepository<Country, Long> {
}