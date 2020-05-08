package com.nikedanz.PokeAPI.resources.v1;

import com.nikedanz.PokeAPI.pojos.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping(path = "v1/Pokemon/")
public class PokemonResource {
    Logger LOGGER = LoggerFactory.getLogger(PokemonResource.class);
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(
            path = "{name}",
            produces = "application/json"
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pokemon> getPokemon(@PathVariable(value="name") String name) {
        LOGGER.info("Looking for Pokemon:" + name);
        Pokemon pokemon = new Pokemon();
        try {
            pokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase(), Pokemon.class);
            LOGGER.info("Pokemon received successfully");
            LOGGER.info(pokemon.toString());
        } catch(Exception e ) {
            LOGGER.error("An error has ocurred: " + e.getMessage());
        }

        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin","*")
                .body(pokemon);
    }
}
