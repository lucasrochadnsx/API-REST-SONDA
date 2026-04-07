package br.com.sonda_teste.aeronaveV2.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class TempoConfig {

    @Bean
    public Clock clock(){ return Clock.systemDefaultZone();}
}
