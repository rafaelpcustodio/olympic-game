package br.com.ciandt.olympic.game.webapp.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that represents a place where a {@link Competition} can happen.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "PLACE", uniqueConstraints = @UniqueConstraint(name = "PLACE_NAME_UK", columnNames = "NAME"))
public class Place {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "place")
    private List<Competition> competitions;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(final List<Competition> competitions) {
        this.competitions = competitions;
    }
}
