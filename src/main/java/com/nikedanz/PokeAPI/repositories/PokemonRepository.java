package com.nikedanz.PokeAPI.repositories;

import com.nikedanz.PokeAPI.pojos.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class PokemonRepository {
    Logger LOGGER = LoggerFactory.getLogger(PokemonRepository.class);

    @Autowired
    RestTemplate restTemplate;

    @Cacheable("pokemon")
    public Pokemon getPokemonFromService(String pokemon_name) {
        try {
            LOGGER.info("Sleeping started");
            TimeUnit.SECONDS.sleep(3);
            LOGGER.info("Sleeping completed");

            String URL = "https://pokeapi.co/api/v2/pokemon/" + pokemon_name.toLowerCase();
            return restTemplate.getForObject(URL, Pokemon.class);

        } catch(RestClientResponseException | InterruptedException e ) {
            LOGGER.error("An error has occurred: " + e.getMessage());
        }

        return null;
    }
}
