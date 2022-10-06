package com.nttdata.patronobservador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PatronObservadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatronObservadorApplication.class, args);
		
		Observable<String> messageSender = Observable.just("Mensaje 1", "Mensaje 2", "Mensaje 3");
	    
		messageSender.subscribe(new Observer<String>() {
		        @Override
		        public void onSubscribe(Disposable d) {
		            System.out.println("Observer. Subscribed.");
		        }

		        @Override
		        public void onNext(String s) {
		            System.out.println("Observer. Received: " + s);
		        }

		        @Override
		        public void onError(Throwable e) {
		            System.out.println("Observer. Error: " + e.getMessage());
		        }

		        @Override
		        public void onComplete() {
		            System.out.println("Observer. Completed");
		        }
		    });
		
		Flux<String> messageSender2 = Flux.just("Mensaje 1", "Mensaje 2", "Mensaje 3");
		
		messageSender2.subscribe(m -> System.out.println("Consumidor recibe "+m),
				e -> System.out.println("Consumidor error "+e.getMessage()),
				() -> System.out.println("Completado"));
		
	}

}
