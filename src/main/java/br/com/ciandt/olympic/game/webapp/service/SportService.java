package br.com.ciandt.olympic.game.webapp.service;

import br.com.ciandt.olympic.game.webapp.mapper.SportMapper;
import br.com.ciandt.olympic.game.webapp.model.dto.SportDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Sport;
import br.com.ciandt.olympic.game.webapp.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling all the processes associated to a {@link Sport}
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    /**
     * Find all the existing sports in the database.
     * @return A list with all the existing sports.
     */
    public List<SportDTO> findAll() {
        final List<Sport> entities = this.sportRepository.findAll();
        return SportMapper.MAPPER.entityToDTO(entities);
    }
}
