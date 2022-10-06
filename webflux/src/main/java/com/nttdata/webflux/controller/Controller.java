package com.nttdata.webflux.controller;

import java.time.Duration;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import reactor.core.publisher.Flux;

@RestController
public class Controller {
	
    @GetMapping(path = "/numbers", produces = "text/event-stream")
    public Flux<Integer> all () {
        Flux<Integer> flux = Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1));

        flux.subscribe(System.out::println); 
        flux.subscribe(n -> System.out.println("Suscriber 2:"+n));
        return flux; 
    }

}
