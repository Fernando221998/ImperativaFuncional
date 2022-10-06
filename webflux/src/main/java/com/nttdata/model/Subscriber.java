package com.nttdata.model;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class Subscriber {

	   
	   Flux<Integer> flux = Flux.range(1,30).delayElements(Duration.ofSeconds(1));
}
