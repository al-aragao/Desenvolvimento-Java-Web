package br.infnet.edu.clientapi.services.models;

import org.springframework.web.multipart.MultipartFile;

public class UserServiceModel {
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
	private String ProfileImageBase64;
	private MultipartFile Image;
	

	
	public MultipartFile getImage() {
		return Image;
	}

	public void setImage(MultipartFile image) {
		Image = image;
	}

	public String getProfileImage() {
		return ProfileImage;
	}

	public void setProfileImage(String profileImage) {
		ProfileImage = profileImage;
	}

	public String getProfileImageBase64() {
		return ProfileImageBase64;
	}

	public void setProfileImageBase64(String profileImageBase64) {
		ProfileImageBase64 = profileImageBase64;
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

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
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
}
