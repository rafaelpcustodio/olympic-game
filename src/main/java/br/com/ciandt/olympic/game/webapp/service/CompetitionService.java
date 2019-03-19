package br.com.ciandt.olympic.game.webapp.service;

import br.com.ciandt.olympic.game.webapp.mapper.CompetitionMapper;
import br.com.ciandt.olympic.game.webapp.model.dto.CompetitionDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Competition;
import br.com.ciandt.olympic.game.webapp.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling all the processes associated to a {@link Competition}
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private CompetitionValidationService competitionValidationService;

    /**
     * Create a certain competition using the provided data inside of a {@link CompetitionDTO}.
     * @param competition The owner of the information to be persisted into the database.
     * @return The persisted competition.
     * @throws RuntimeException Some data of the competition were wrongly filled.
     */
    public CompetitionDTO create(final CompetitionDTO competition) throws RuntimeException {
        // Performs validations before persisting the competition.
        this.competitionValidationService.validateBeforeCreate(competition);
        final Competition competitionToPersist = CompetitionMapper.MAPPER.dtoToEntity(competition);
        final CompetitionDTO persistedCompetition = CompetitionMapper
                .MAPPER.entityToDTO(this.competitionRepository.save(competitionToPersist));
        return persistedCompetition;
    }

    /**
     * Find all the existing competitions ordered by the begin date desc.
     * @return The list with all the competitions ordered by the begin date.
     */
    public List<CompetitionDTO> findAllByOrderByBeginDate() {
        final List<Competition> entities = this.competitionRepository.findAllByOrderByBeginDateDesc();
        return CompetitionMapper.MAPPER.entityToDTO(entities);
    }
}
