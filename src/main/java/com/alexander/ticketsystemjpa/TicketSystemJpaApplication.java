package com.alexander.ticketsystemjpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.alexander")
@EntityScan("com.alexander.ticketsystemjpa.entity")
public class TicketSystemJpaApplication {
    private static final Logger logger = LoggerFactory.getLogger(TicketSystemJpaApplication.class);

    public static void main(String[] args) {
        logger.debug("Starting app");
        SpringApplication.run(TicketSystemJpaApplication.class, args);
    }
}