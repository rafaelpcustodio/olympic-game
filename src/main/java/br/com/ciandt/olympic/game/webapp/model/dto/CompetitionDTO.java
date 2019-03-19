package br.com.ciandt.olympic.game.webapp.model.dto;

import br.com.ciandt.olympic.game.webapp.enumerable.CompetitionType;
import br.com.ciandt.olympic.game.webapp.util.LocalDateTimeDeserializer;
import br.com.ciandt.olympic.game.webapp.util.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

/**
 * Data Transfer Object that represents a specific competition between two {@link CountryDTO}
 *
 * @author rafaelcustodio
 */
public class CompetitionDTO {

    private Long id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime beginDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endDate;

    private CompetitionType type;

    private PlaceDTO place;

    private SportDTO sport;

    private CountryDTO firstCompetitor;

    private CountryDTO secondCompetitor;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(final LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public CompetitionType getType() {
        return type;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(final PlaceDTO place) {
        this.place = place;
    }

    public void setType(final CompetitionType type) {
        this.type = type;
    }

    public SportDTO getSport() {
        return sport;
    }

    public void setSport(final SportDTO sport) {
        this.sport = sport;
    }

    public CountryDTO getFirstCompetitor() {
        return firstCompetitor;
    }

    public void setFirstCompetitor(final CountryDTO firstCompetitor) {
        this.firstCompetitor = firstCompetitor;
    }

    public CountryDTO getSecondCompetitor() {
        return secondCompetitor;
    }

    public void setSecondCompetitor(final CountryDTO secondCompetitor) {
        this.secondCompetitor = secondCompetitor;
    }
}