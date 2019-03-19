package br.com.ciandt.olympic.game.webapp.model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that represents a modality of competition.
 *
 * @author rafaelcustodio
 */
@Entity
@Table(name = "SPORT", uniqueConstraints = @UniqueConstraint(name = "SPORT_NAME_UK", columnNames = "NAME"))
public class Sport {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "sport")
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

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(final List<Competition> competitions) {
        this.competitions = competitions;
    }
}
