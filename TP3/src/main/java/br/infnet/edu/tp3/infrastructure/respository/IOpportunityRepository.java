package br.infnet.edu.tp3.infrastructure.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.infnet.edu.tp3.domain.entities.Opportunity;

@Repository
public interface IOpportunityRepository extends CrudRepository<Opportunity, Integer> {
	@Query("from Opportunity o where o.Name =:name")
	public Opportunity getByName(String name);
	
	@Query("from Opportunity o where o.user.Id =:userId")
	public List<Opportunity> findAllFromUser(Integer userId);
}
