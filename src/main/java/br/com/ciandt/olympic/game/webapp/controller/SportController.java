package br.com.ciandt.olympic.game.webapp.controller;

import br.com.ciandt.olympic.game.webapp.model.dto.SportDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Sport;
import br.com.ciandt.olympic.game.webapp.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Represents the responsible for defining all the endpoints related to a {@link Sport}
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(path = "/sports")
public class SportController {

    @Autowired
    private SportService sportService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<SportDTO> findAll(){
        return this.sportService.findAll();
    }
}