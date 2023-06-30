package service;

import model.Endereco;
import reactor.core.publisher.Mono;

public class CepValidator {
	
	ViaCepService end = new ViaCepService();
	
	
	public boolean quantityValidate(String cep) {
		if (cep.length() == 8) {
			return true;
		}
		else {
			System.out.println("O CEO precisa ter 8 números. Sem espaços ou símbolos.");
			return false;
		}
	}
	public boolean isValidCep(String cep) {
		   Mono<Endereco> api = end.getEndereco(cep);
		    Endereco endereco = api.block(); // Obtém o resultado do Mono de forma síncrona
		    if (endereco != null && endereco.isErro()) {
		        System.out.println("O CEP não existe no sistema.");
		        return false;
		    }
		    return true;
		} 

}
