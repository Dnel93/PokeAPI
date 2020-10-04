package com.nikedanz.PokeAPI.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EmbeddedCacheConfig {

    @Bean
    Config config() {
        System.out.println("Enabling Cache");
        Config config = new Config();

        MapConfig mapConfig = new MapConfig();
        mapConfig.setTimeToLiveSeconds(300);
        config.getMapConfigs().put("pokemon", mapConfig);

        return config;
    }
}
