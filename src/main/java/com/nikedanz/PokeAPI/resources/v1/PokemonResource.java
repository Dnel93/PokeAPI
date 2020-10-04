package com.nikedanz.PokeAPI.resources.v1;

import com.nikedanz.PokeAPI.exceptions.PokemonNotFound;
import com.nikedanz.PokeAPI.pojos.Pokemon;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "v1/")
public class PokemonResource {
    Logger LOGGER = LoggerFactory.getLogger(PokemonResource.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Pokemon pokemon;

    @GetMapping(
            path = "{name}",
            produces = "application/json"
    )
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Provides the information of certain pokemon based on it's name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Pokemon received"),
            @ApiResponse(code = 404, message = "Pokemon not found")
    })
    public ResponseEntity<Pokemon> getPokemon(
            @ApiParam(name = "name", required = true, example = "pikachu") @PathVariable(value="name") String name
    ) throws PokemonNotFound {
        LOGGER.info("Looking for Pokemon:" + name);

        try {
            String URL = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();
            pokemon = restTemplate.getForObject(URL, Pokemon.class);
        } catch(RestClientResponseException e ) {
            LOGGER.error("An error has occurred: " + e.getMessage());
        }

        if(pokemon.getId() == 0) {
            throw new PokemonNotFound("Not found");
        }

        return ResponseEntity
                .ok()
                .body(pokemon);
    }
}
