package com.DermApp.Backend.diagnostic.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("overviewMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DermatologistMapper dermatologistMapper(){
        return new DermatologistMapper();
    }

    @Bean
    public PatientMapper patientMapper(){
        return new PatientMapper();
    }

    @Bean
    public FileMapper fileMapper(){
        return new FileMapper();
    }

    @Bean
    public ChatMapper chatMapper(){
        return new ChatMapper();
    }

    @Bean
    public ScheduleMapper scheduleMapper(){
        return new ScheduleMapper();
    }


}
