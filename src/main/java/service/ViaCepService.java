package service;

import org.springframework.web.reactive.function.client.WebClient;

import model.Endereco;
import reactor.core.publisher.Mono;

public class ViaCepService {
	String cep;
	
	WebClient webClient = WebClient.create("https://viacep.com.br/ws/");
	public Mono<Endereco> getEndereco(String cep) {
		return webClient.get()
				.uri("/{cep}" + "/json", cep)
				.retrieve()
				.bodyToMono(Endereco.class);		
	}

}
