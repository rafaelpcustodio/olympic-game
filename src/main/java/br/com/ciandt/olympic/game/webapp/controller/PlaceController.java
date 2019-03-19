package br.com.ciandt.olympic.game.webapp.controller;

import br.com.ciandt.olympic.game.webapp.model.dto.PlaceDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Place;
import br.com.ciandt.olympic.game.webapp.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Represents the responsible for defining all the endpoints related to a {@link Place}
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(path = "/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<PlaceDTO> findAll(){
        return this.placeService.findAll();
    }
}