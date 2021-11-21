package br.infnet.edu.tp3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.infnet.edu.tp3.domain.entities.Opportunity;
import br.infnet.edu.tp3.infrastructure.respository.IOpportunityRepository;

@Service
public class OpportunityService {
	
	@Autowired
	private IOpportunityRepository opportunityRepository;

	public List<Opportunity> getAll(){
		return (List<Opportunity>)opportunityRepository.findAll();
	}

	public List<Opportunity> getAll(Integer userId){
		return (List<Opportunity>)opportunityRepository.findAllFromUser(userId);
	}
	
	public Optional<Opportunity> getById(Integer id){
		return opportunityRepository.findById(id);
	}
	
	public List<String> add(Opportunity opportunity) {
		
		if(opportunity.IsValid())
		{
			opportunityRepository.save(opportunity);
		}
		
		return opportunity.GetValidationErrors();		
	}
	
	public void delete(Integer id) {
		opportunityRepository.deleteById(id);
	}
}
