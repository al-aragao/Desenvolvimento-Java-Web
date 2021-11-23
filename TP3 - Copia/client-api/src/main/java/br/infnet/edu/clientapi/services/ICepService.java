package br.infnet.edu.clientapi.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.infnet.edu.clientapi.services.models.AddressServiceModel;

@FeignClient(url = "https://viacep.com.br/ws/", name = "cepService")
public interface ICepService {

	@GetMapping("/{cep}/json")
	AddressServiceModel get(@PathVariable("cep") String cep);
}
