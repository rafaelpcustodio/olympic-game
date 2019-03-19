package br.com.ciandt.olympic.game.webapp.model.entity;

import br.com.ciandt.olympic.game.webapp.enumerable.CompetitionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity that represents a specific competition between two {@link Country}
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "COMPETITION")
public class Competition {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BEGIN_DATE")
    private Date beginDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private CompetitionType type;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "SPORT_ID")
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "FIRST_COMPETITOR_ID")
    private Country firstCompetitor;

    @ManyToOne
    @JoinColumn(name = "SECOND_COMPETITOR_ID")
    private Country secondCompetitor;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(final Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public CompetitionType getType() {
        return type;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(final Place place) {
        this.place = place;
    }

    public void setType(final CompetitionType type) {
        this.type = type;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(final Sport sport) {
        this.sport = sport;
    }

    public Country getFirstCompetitor() {
        return firstCompetitor;
    }

    public void setFirstCompetitor(final Country firstCompetitor) {
        this.firstCompetitor = firstCompetitor;
    }

    public Country getSecondCompetitor() {
        return secondCompetitor;
    }

    public void setSecondCompetitor(final Country secondCompetitor) {
        this.secondCompetitor = secondCompetitor;
    }
}