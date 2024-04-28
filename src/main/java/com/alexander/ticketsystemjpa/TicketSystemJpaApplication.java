package com.alexander.ticketsystemjpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.alexander")
@EntityScan("com.alexander.ticketsystemjpa.entity")
public class TicketSystemJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketSystemJpaApplication.class, args);
    }
}