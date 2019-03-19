package br.com.ciandt.olympic.game.webapp.repository;

import br.com.ciandt.olympic.game.webapp.model.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * {@link Competition} Data Access Object.
 *
 * @author rafaelcustodio
 */
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    /**
     * Find all the existing competitions ordered by the begin date.
     * @return The list with all the competitions ordered by the begin date.
     */
    List<Competition> findAllByOrderByBeginDateDesc();
}