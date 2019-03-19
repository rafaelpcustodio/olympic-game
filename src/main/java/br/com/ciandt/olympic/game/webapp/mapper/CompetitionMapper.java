package br.com.ciandt.olympic.game.webapp.mapper;

import br.com.ciandt.olympic.game.webapp.model.dto.CompetitionDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CountryMapper.class, PlaceMapper.class, SportMapper.class}, imports = {java.util.Date.class})
public interface CompetitionMapper {

    CompetitionMapper MAPPER = Mappers.getMapper(CompetitionMapper.class);

    /**
     * Maps a data transfer object to its representation in entity.
     * @param competition The object to be converted.
     * @return The converted object as result.
     */
    Competition dtoToEntity(CompetitionDTO competition);

    /**
     * Maps a entity to its representation in data transfer object.
     * @param competition The object to be converted.
     * @return The converted object as result.
     */
    CompetitionDTO entityToDTO(Competition competition);

    /**
     * Maps a list of entities to their representation in data transfer objects.
     * @param competitions The list of the objects to be converted.
     * @return The converted object list as result.
     */
    List<CompetitionDTO> entityToDTO(List<Competition> competitions);
}
