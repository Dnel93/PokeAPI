package com.nikedanz.PokeAPI.resources.v1;

import com.nikedanz.PokeAPI.exceptions.PokemonNotFound;
import com.nikedanz.PokeAPI.pojos.Pokemon;
import com.nikedanz.PokeAPI.repositories.PokemonRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "v1/")
public class PokemonResource {
    Logger LOGGER = LoggerFactory.getLogger(PokemonResource.class);

    @Autowired
    PokemonRepository pokemonRepository;

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
        Pokemon pokemon = pokemonRepository.getPokemonFromService(name);

        if(pokemon.getId() == 0) {
            throw new PokemonNotFound("Not found");
        }

        return ResponseEntity
                .ok()
                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:3000")
                .body(pokemon);
    }
}
