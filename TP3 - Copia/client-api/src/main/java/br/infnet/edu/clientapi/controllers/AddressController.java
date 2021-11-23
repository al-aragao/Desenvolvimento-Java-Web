package br.infnet.edu.clientapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.infnet.edu.clientapi.services.ICepService;
import br.infnet.edu.clientapi.services.models.AddressServiceModel;

@RestController
@RequestMapping("Address")
public class AddressController {


	@Autowired
	private ICepService _cepService;

	@GetMapping(value = "/{addressCode}")
	public AddressServiceModel GetAddressData(@PathVariable(value = "addressCode") String addressCode) {
		System.out.println(addressCode);
		AddressServiceModel address =_cepService.get(addressCode);
		System.out.println(address.getBairro());
		return address;
	}
}
