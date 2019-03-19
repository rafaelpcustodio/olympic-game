package br.com.ciandt.olympic.game.webapp.mapper;

import br.com.ciandt.olympic.game.webapp.model.dto.PlaceDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Place;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlaceMapper {

    PlaceMapper MAPPER = Mappers.getMapper(PlaceMapper.class);

    /**
     * Maps a data transfer object to its representation in entity.
     * @param place The object to be converted.
     * @return The converted object as result.
     */
    Place dtoToEntity(PlaceDTO place);

    /**
     * Maps a entity to its representation in data transfer object.
     * @param place The object to be converted.
     * @return The converted object as result.
     */
    PlaceDTO entityToDTO(Place place);

    /**
     * Maps a list of entities to their representation in data transfer objects.
     * @param places The list of the objects to be converted.
     * @return The converted object list as result.
     */
    List<PlaceDTO> entityToDTO(List<Place> places);
}
