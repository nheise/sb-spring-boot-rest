package de.heisemedia.gateway.runtime;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan( { "de.heisemedia.gateway.controller" } )
public class ApplicationStarter {

    public static void main( String[] args ) {
        SpringApplication.run( ApplicationStarter.class, args );
    }

}
