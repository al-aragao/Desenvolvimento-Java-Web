package br.infnet.edu.tp3.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Opportunity {

	public Opportunity() {
		ValidationErrors = new ArrayList<String>();
	}

	public Opportunity(String name, String description, String createdOn) {
		Name = name;
		Description = description;
		ValidationErrors = new ArrayList<String>();
	}

	@Transient
	private List<String> ValidationErrors;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private String Description;
	
	@ManyToOne
	@JoinColumn(name="IdUsuario")
	private User user;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opportunity other = (Opportunity) obj;
		return Objects.equals(Id, other.Id);
	}

	public boolean IsValid() {
		this.ValidateName();
		this.ValidateDescription();
		
		return this.ValidationErrors.size() == 0;
	}

	public List<String> GetValidationErrors() {
		return this.ValidationErrors;
	}

	private void ValidateName() {
		if (StringUtils.isBlank(this.Name)) {
			ValidationErrors.add("The name is required");
		}
	}

	private void ValidateDescription() {
		if (StringUtils.isBlank(this.Description)) {
			ValidationErrors.add("The description is required");
		}
	}

}
