package br.com.ciandt.olympic.game.webapp.service;

import br.com.ciandt.olympic.game.webapp.mapper.PlaceMapper;
import br.com.ciandt.olympic.game.webapp.model.dto.PlaceDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Place;
import br.com.ciandt.olympic.game.webapp.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling all the processes associated to a {@link Place}
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    /**
     * Find all the existing countries in the database.
     * @return A list with all the existing places.
     */
    public List<PlaceDTO> findAll() {
        final List<Place> entities = this.placeRepository.findAll();
        return PlaceMapper.MAPPER.entityToDTO(entities);
    }
}
