package br.com.ciandt.olympic.game.webapp.model.dto;

/**
 * Data Transfer Object that represents a country that can participate of an {@link br.com.ciandt.olympic.game.webapp.model.entity.Competition}
 *
 * @author rafaelcustodio
 */
public class CountryDTO {

    private Long id;

    private String name;

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
}