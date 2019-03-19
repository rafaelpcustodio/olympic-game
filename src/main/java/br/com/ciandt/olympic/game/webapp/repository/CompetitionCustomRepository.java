package br.com.ciandt.olympic.game.webapp.repository;

import br.com.ciandt.olympic.game.webapp.model.entity.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Custom {@link Competition} Data Access Object.
 *
 * @author rafaelcustodio
 */
@Repository
public class CompetitionCustomRepository {

    @Autowired
    private EntityManager entityManager;

    /**
     * Find all specific competitions by a combination of period, place and sport category.
     * @param beginDate The begging of the period.
     * @param endDate The end of the period.
     * @param placeId The identifier of the place where the competition is happening.
     * @param sportId The identifier of the sport category.
     * @return List with all {@link Competition}.
     */
    public List<Competition> findByPeriodAndPlaceIdAndSportId(final LocalDateTime beginDate, final LocalDateTime endDate, final Long placeId, final Long sportId) {

        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(" SELECT C.* FROM COMPETITION C ");
        queryBuilder.append(" INNER JOIN PLACE P ON P.ID = C.PLACE_ID ");
        queryBuilder.append(" INNER JOIN SPORT S ON S.ID = C.SPORT_ID ");
        queryBuilder.append(" WHERE C.BEGIN_DATE >= :beginDate AND C.END_DATE <= :endDate");
        queryBuilder.append(" AND C.PLACE_ID = :placeId AND C.SPORT_ID <= :sportId");

        final Query query = this.entityManager.createNativeQuery(queryBuilder.toString(), Competition.class);
        query.setParameter("placeId", placeId);
        query.setParameter("sportId", sportId);
        query.setParameter("beginDate", Timestamp.valueOf(beginDate));
        query.setParameter("endDate", Timestamp.valueOf(endDate));

        return query.getResultList();
    }
}