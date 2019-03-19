package br.com.ciandt.olympic.game.webapp.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that represents a country that can participate of an {@link Competition}
 *
 * @author rafaelcustodio
 */
@Entity
@Table(
    name = "COUNTRY",
    uniqueConstraints = @UniqueConstraint(name = "COUNTRY_NAME_UK", columnNames = "NAME")
)
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "firstCompetitor")
    private List<Competition> principalCompetitions;

    @OneToMany(mappedBy = "secondCompetitor")
    private List<Competition> secondaryCompetitions;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Competition> getPrincipalCompetitions() {
        return principalCompetitions;
    }

    public void setPrincipalCompetitions(List<Competition> principalCompetitions) {
        this.principalCompetitions = principalCompetitions;
    }

    public List<Competition> getSecondaryCompetitions() {
        return secondaryCompetitions;
    }

    public void setSecondaryCompetitions(List<Competition> secondaryCompetitions) {
        this.secondaryCompetitions = secondaryCompetitions;
    }
}
