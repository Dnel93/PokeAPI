package com.nikedanz.PokeAPI.resources.v1;

import com.nikedanz.PokeAPI.exceptions.PokemonNotFound;
import com.nikedanz.PokeAPI.pojos.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping(path = "v1/")
public class PokemonResource {
    Logger LOGGER = LoggerFactory.getLogger(PokemonResource.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(
            path = "{name}",
            produces = "application/json"
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pokemon> getPokemon(@PathVariable(value="name") String name) throws PokemonNotFound {
        LOGGER.info("Looking for Pokemon:" + name);
        Pokemon pokemon = new Pokemon();
        try {
            String URL = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();
            LOGGER.info("This is the URL:" + URL);

            pokemon = restTemplate.getForObject(URL, Pokemon.class);

            LOGGER.info("Pokemon received successfully");
            LOGGER.info(pokemon.toString());
        } catch(RestClientResponseException e ) {
            LOGGER.error("An error has occurred: " + e.getMessage());
        }

        if(pokemon.getId() == 0) {
            throw new PokemonNotFound("Not found");
        }

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin","*")
                .body(pokemon);
    }
}
