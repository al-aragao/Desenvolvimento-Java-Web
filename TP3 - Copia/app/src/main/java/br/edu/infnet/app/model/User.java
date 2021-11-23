package br.edu.infnet.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.Entity;

import org.apache.commons.lang3.StringUtils;

//import br.infnet.edu.tp3.domain.entities.Opportunity;
//import br.infnet.edu.tp3.domain.entities.User;

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

	

public User(String name, String email, String phone, String addressCode, String street, String number,
			String complement, String city, String district, String state, String password, String profileImage) {
		
		Name = name;
		Email = email;
		Phone = phone;
		AddressCode = addressCode;
		Street = street;
		Number = number;
		Complement = complement;
		City = city;
		District = district;
		State = state;
		Password = password;
		ProfileImage = profileImage;
		ValidationErrors = new ArrayList<String>();
	}



	@Transient
	private List<String> ValidationErrors;
	
//	@OneToMany
//	@JoinColumn(name="IdUsuario")
//	private List<Opportunity> Opportunities;
//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private String Email;
	private String Phone;
	private String AddressCode;
	private String Street;
	private String Number;
	private String Complement;
	private String City;
	private String District;
	private String State;
	private String Password;
	private String ProfileImage;
	
	@Transient
	private String ProfileImageBase64;
	
	public String getProfileImageBase64() {
		return ProfileImageBase64;
	}

	public void setProfileImageBase64(String profileImageBase64) {
		ProfileImageBase64 = profileImageBase64;
	}

	public String getProfileImage() {
		return ProfileImage;
	}

	public void setProfileImage(String profileImage) {
		ProfileImage = profileImage;
	}

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
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getComplement() {
		return Complement;
	}
	public void setComplement(String complement) {
		Complement = complement;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
		this.ValidateAddressCode();
		this.ValidateEmail();
		this.ValidatePassword(confirmationPassword);
		this.ValidatePhone();
		this.ValidateStreet();
		this.ValidateCity();
		this.ValidateDistrict();
		this.ValidateState();
		
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

	private void ValidateStreet() {
		if (StringUtils.isBlank(this.Street)) {
			ValidationErrors.add("The street is required");
		}
	}

	private void ValidateCity() {
		if (StringUtils.isBlank(this.City)) {
			ValidationErrors.add("The city is required");
		}
	}

	private void ValidateDistrict() {
		if (StringUtils.isBlank(this.District)) {
			ValidationErrors.add("The district is required");
		}
	}

	private void ValidateState() {
		if (StringUtils.isBlank(this.State)) {
			ValidationErrors.add("The state is required");
		}
	}

	private void ValidatePassword(String confirmationPassword) {
		if(!this.Password.equals(confirmationPassword)) {
			ValidationErrors.add("The password and confirmation password are differents");
		}
	}
}