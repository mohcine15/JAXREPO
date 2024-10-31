package com.example.JaxTP.Config;

import com.example.JaxTP.rest.CompteRestJaxRSapi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyConfig = new ResourceConfig();
        jerseyConfig.register(CompteRestJaxRSapi.class);
        return jerseyConfig;
    }
}
