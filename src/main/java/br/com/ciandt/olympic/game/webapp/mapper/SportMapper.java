package br.com.ciandt.olympic.game.webapp.mapper;

import br.com.ciandt.olympic.game.webapp.model.dto.SportDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Sport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SportMapper {

    SportMapper MAPPER = Mappers.getMapper(SportMapper.class);

    /**
     * Maps a data transfer object to its representation in entity.
     * @param sport The object to be converted.
     * @return The converted object as result.
     */
    Sport dtoToEntity(SportDTO sport);

    /**
     * Maps a entity to its representation in data transfer object.
     * @param sport The object to be converted.
     * @return The converted object as result.
     */
    SportDTO entityToDTO(Sport sport);

    /**
     * Maps a list of entities to their representation in data transfer objects.
     * @param sports The list of the objects to be converted.
     * @return The converted object list as result.
     */
    List<SportDTO> entityToDTO(List<Sport> sports);
}
