package br.com.ciandt.olympic.game.webapp.controller;

import br.com.ciandt.olympic.game.webapp.enumerable.CompetitionType;
import br.com.ciandt.olympic.game.webapp.model.dto.CompetitionDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Competition;
import br.com.ciandt.olympic.game.webapp.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the responsible for defining all the endpoints related to a {@link Competition}
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(path = "/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<CompetitionDTO> findAll(){
        return this.competitionService.findAllByOrderByBeginDate();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<CompetitionType> findAllPossibleTypes() {
        return Arrays.asList(CompetitionType.values());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public CompetitionDTO create(@RequestBody final CompetitionDTO competition) {
        return this.competitionService.create(competition);
    }
}
