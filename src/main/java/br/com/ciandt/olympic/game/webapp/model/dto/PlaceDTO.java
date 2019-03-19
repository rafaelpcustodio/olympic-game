package br.com.ciandt.olympic.game.webapp.model.dto;

/**
 * Data Transfer Object that represents a place where a {@link br.com.ciandt.olympic.game.webapp.model.entity.Competition} can happen.
 *
 * @author rafaelcustodio
 */
public class PlaceDTO {

    private Long id;

    private String name;

    private String description;

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
}