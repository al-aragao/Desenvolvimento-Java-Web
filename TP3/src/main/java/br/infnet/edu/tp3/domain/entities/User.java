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
import javax.persistence.OneToMany;

@Entity
@Table(name = "Users")
public class User {

	public User() {
		ValidationErrors = new ArrayList<String>();
	}

	public User(String email, String password) {
		Email = email;
		Password = password;
		ValidationErrors = new ArrayList<String>();
	}

	public User(String name, String email, String phone, String addressCode, String address, String password) {
		Name = name;
		Email = email;
		Phone = phone;
		AddressCode = addressCode;
		Address = address;
		Password = password;
		ValidationErrors = new ArrayList<String>();
	}

	@Transient
	private List<String> ValidationErrors;
	
	@OneToMany
	@JoinColumn(name="IdUsuario")
	private List<Opportunity> Opportunities;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private String Email;
	private String Phone;
	private String AddressCode;
	private String Address;
	private String Password;

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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddressCode() {
		return AddressCode;
	}

	public void setAddressCode(String addressCode) {
		AddressCode = addressCode;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	

	public List<Opportunity> getOpportunities() {
		return Opportunities;
	}

	public void setOpportunities(List<Opportunity> opportunities) {
		Opportunities = opportunities;
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
		User other = (User) obj;
		return Objects.equals(Id, other.Id);
	}

	public boolean IsValid(String confirmationPassword) {
		this.ValidateName();
		this.ValidateAddress();
		this.ValidateAddressCode();
		this.ValidateEmail();
		this.ValidatePassword(confirmationPassword);
		this.ValidatePhone();
		
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

	private void ValidateEmail() {
		if (StringUtils.isBlank(this.Email)) {
			ValidationErrors.add("The email is required");
		}
	}

	private void ValidatePhone() {
		if (StringUtils.isBlank(this.Phone)) {
			ValidationErrors.add("The phone is required");
		}
	}

	private void ValidateAddressCode() {
		if (StringUtils.isBlank(this.AddressCode)) {
			ValidationErrors.add("The address code is required");
		}
	}

	private void ValidateAddress() {
		if (StringUtils.isBlank(this.Address)) {
			ValidationErrors.add("The address is required");
		}
	}

	private void ValidatePassword(String confirmationPassword) {
		if(!this.Password.equals(confirmationPassword)) {
			ValidationErrors.add("The password and confirmation password are differents");
		}
	}

}
