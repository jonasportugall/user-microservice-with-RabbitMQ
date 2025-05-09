package com.microservice.user.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Este bean configura o conversor de mensagens do RabbitMQ para usar JSON.
    // Ele permite que objetos Java sejam automaticamente serializados e desserializados para/desde JSON
    // ao serem enviados ou recebidos por filas, facilitando a comunicação entre serviços.
    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter( objectMapper );
    }

}
