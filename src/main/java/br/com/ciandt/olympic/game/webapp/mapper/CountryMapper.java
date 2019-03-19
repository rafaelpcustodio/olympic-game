package br.com.ciandt.olympic.game.webapp.mapper;

import br.com.ciandt.olympic.game.webapp.model.dto.CountryDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {

    CountryMapper MAPPER = Mappers.getMapper(CountryMapper.class);

    /**
     * Maps a data transfer object to its representation in entity.
     * @param country The object to be converted.
     * @return The converted object as result.
     */
    Country dtoToEntity(CountryDTO country);

    /**
     * Maps a entity to its representation in data transfer object.
     * @param country The object to be converted.
     * @return The converted object as result.
     */
    CountryDTO entityToDTO(Country country);

    /**
     * Maps a list of entities to their representation in data transfer objects.
     * @param countries The list of the objects to be converted.
     * @return The converted object list as result.
     */
    List<CountryDTO> entityToDTO(List<Country> countries);
}
