package com.felepe;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Endereco;
import reactor.core.publisher.Mono;
import service.CepValidator;
import service.ViaCepService;

@SpringBootApplication
public class ApiviacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiviacepApplication.class, args);
		Scanner sc = new Scanner(System.in);		
		ViaCepService api = new ViaCepService();
		CepValidator cepValidade = new CepValidator();		
		
		
		boolean cepCondicional = false;
		do {
			System.out.println("Digite o CEP que deseja buscar. Somente números: ");
			String cep = sc.next();
		if (cepValidade.quantityValidate(cep) == true && cepValidade.isValidCep(cep) == true) {
			Mono<Endereco> end = api.getEndereco(cep);
			end.subscribe(endereco -> {				
				System.out.println("CEP: " + endereco.getCep());
				System.out.println("Logradouro: " + endereco.getLogradouro());
				System.out.println("Bairro: " + endereco.getBairro());
				System.out.println("Localidade: " + endereco.getLocalidade());
				System.out.println("UF: " + endereco.getUf());				
				});
			cepCondicional = true;
		}		
		}
		while(!cepCondicional);			
		sc.close();
		}
}


				








