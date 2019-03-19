package br.com.ciandt.olympic.game.webapp.service;

import br.com.ciandt.olympic.game.webapp.enumerable.CompetitionType;
import br.com.ciandt.olympic.game.webapp.enumerable.CompetitionValidationError;
import br.com.ciandt.olympic.game.webapp.model.dto.CompetitionDTO;
import br.com.ciandt.olympic.game.webapp.model.dto.CountryDTO;
import br.com.ciandt.olympic.game.webapp.model.dto.PlaceDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Competition;
import br.com.ciandt.olympic.game.webapp.model.entity.Country;
import br.com.ciandt.olympic.game.webapp.model.entity.Place;
import br.com.ciandt.olympic.game.webapp.repository.CompetitionCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service responsible for handling all the processes associated to a {@link Competition}
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class CompetitionValidationService {

    private static final int MIN_DURATION_MINUTES = 30;

    @Autowired
    private CompetitionCustomRepository competitionRepository;

    /**
     * Execute validations before the creation of a {@link Competition}.
     * @param competition A {@link Competition} holding all the data of a competition.
     */
    public void validateBeforeCreate(final CompetitionDTO competition) throws RuntimeException {
        this.validateMandatoryField(competition);
        this.validateCompetitionCocurrency(competition);
    }

    /**
     * Performs validation over all the mandatory fields of a competition
     * @param competition A {@link Competition} holding all the data of a competition.
     * @throws RuntimeException There is an error for the provided competition data.
     */
    private void validateMandatoryField(final CompetitionDTO competition) throws RuntimeException {
        this.validatePeriod(competition.getBeginDate(), competition.getEndDate());
        this.validateCompetitor(competition.getFirstCompetitor(), competition.getSecondCompetitor());
        this.validatePlace(competition.getPlace());
        this.validateCompetitionType(competition.getType());
    }

    /**
     * Verifies if there is already a registered competition for a place at a certain period.
     * @param competition The data of the competition used as base for the comparision.
     * @throws RuntimeException There is already a competition for the period and place.
     */
    private void validateCompetitionCocurrency(CompetitionDTO competition) throws RuntimeException {
        if(this.isExistingCompetitionForPeriodAndPlace(competition)) {
            final PlaceDTO place = competition.getPlace();
            final LocalDateTime beginDate = competition.getBeginDate();
            final LocalDateTime endDate = competition.getEndDate();
            final String error = String.format( CompetitionValidationError.CONCURRENCY_ERROR.getMessage(),
                    place.getName(), beginDate.toString(), endDate.toString());
            throw new RuntimeException(error);
        }
    }

    /**
     * Validate all the data related to the period that a competition will happen.
     * @param beginDate The initial date for the period.
     * @param endDate The final date for the period.
     * @throws RuntimeException There is an error for the provided period data.
     */
    private void validatePeriod(final LocalDateTime beginDate, final LocalDateTime endDate) throws RuntimeException {
        if(ObjectUtils.isEmpty(beginDate)) {
            throw new RuntimeException(CompetitionValidationError.PERIOD_BEGINNING_EMPTY_ERROR.getMessage());
        } else if(ObjectUtils.isEmpty(endDate)) {
            throw new RuntimeException(CompetitionValidationError.PERIOD_ENDING_EMPTY_ERROR.getMessage());
        } else if(Duration.between(beginDate, endDate).compareTo(Duration.ofMinutes(MIN_DURATION_MINUTES)) < 0) {
            final String error = String.format(CompetitionValidationError.PERIOD_DURATION_ERROR.getMessage(), MIN_DURATION_MINUTES);
            throw new RuntimeException(error);
        }
    }

    /**
     * Execute validations over the data associated to two competitors {@link Country}.
     * @param firstCompetitor The object containing the data of the first competitor.
     * @param secondCompetitor The object containing the data of the second competitor.
     * @throws RuntimeException There is an error for the provided competitors data.
     */
    private void validateCompetitor(final CountryDTO firstCompetitor, final CountryDTO secondCompetitor) throws RuntimeException {
        if(ObjectUtils.isEmpty(firstCompetitor) || ObjectUtils.isEmpty(firstCompetitor.getId())) {
            final String error = String.format(CompetitionValidationError.COMPETITOR_EMPTY_ERROR.getMessage(), "first");
            throw new RuntimeException(error);
        } else if(ObjectUtils.isEmpty(secondCompetitor) || ObjectUtils.isEmpty(secondCompetitor.getId())) {
            final String error = String.format(CompetitionValidationError.COMPETITOR_EMPTY_ERROR.getMessage(), "second");
            throw new RuntimeException(error);
        }
    }

    /**
     * Execute validations over the data associated to the a {@link Place}.
     * @param place The object containing the data of the field to be validated.
     * @throws RuntimeException There is an error for the provided place data.
     */
    private void validatePlace(final PlaceDTO place) throws RuntimeException {
        if(ObjectUtils.isEmpty(place) || ObjectUtils.isEmpty(place.getId())) {
            throw new RuntimeException(CompetitionValidationError.PLACE_EMPTY_ERROR.getMessage());
        }
    }

    /**
     * Execute validations over the data associated to the a {@link CompetitionType}.
     * @param type The object containing the data of the field to be validated.
     * @throws RuntimeException There is an error for the provided competition type data.
     */
    private void validateCompetitionType(final CompetitionType type) throws RuntimeException {
        if(ObjectUtils.isEmpty(type)) {
            throw new RuntimeException(CompetitionValidationError.TYPE_EMPTY_ERROR.getMessage());
        }
    }

    /**
     * Verifies if the competition already exists in the database for the same period.
     * @param competition The competition to be validated.
     * @return <code>true </code>: The competition already exists. </br>
     *         <cdde>false </cdde>: The competition does not exist.
     */
    private boolean isExistingCompetitionForPeriodAndPlace(final CompetitionDTO competition) {

        final List<Competition> competitions = this.competitionRepository.findByPeriodAndPlaceIdAndSportId(
                competition.getBeginDate(), competition.getEndDate(), competition.getPlace().getId(),
                competition.getSport().getId());

        return !ObjectUtils.isEmpty(competitions);
    }
}
