package br.com.ciandt.olympic.game.webapp.service;

import br.com.ciandt.olympic.game.webapp.mapper.CountryMapper;
import br.com.ciandt.olympic.game.webapp.model.dto.CountryDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Country;
import br.com.ciandt.olympic.game.webapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling all the processes associated to a {@link Country}
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * Find all the existing countries in the database.
     * @return A list with all the existing countries.
     */
    public List<CountryDTO> findAll() {
        final List<Country> entities = this.countryRepository.findAll();
        return CountryMapper.MAPPER.entityToDTO(entities);
    }
}
