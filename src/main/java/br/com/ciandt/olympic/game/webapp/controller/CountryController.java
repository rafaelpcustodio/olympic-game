package br.com.ciandt.olympic.game.webapp.controller;

import br.com.ciandt.olympic.game.webapp.model.dto.CountryDTO;
import br.com.ciandt.olympic.game.webapp.model.entity.Country;
import br.com.ciandt.olympic.game.webapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Represents the responsible for defining all the endpoints related to a {@link Country}
 *
 * @author rafaelcustodio
 */
@RestController
@RequestMapping(path = "/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<CountryDTO> findAll(){
        return this.countryService.findAll();
    }
}