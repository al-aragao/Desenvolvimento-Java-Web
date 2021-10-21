package br.edu.infnet.domain.models;

public class Aluno {
	private String Name;
	private String Email;
	private String Password;

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

	public Aluno(String name, String email, String password) {		
		Name = name;
		Email = email;
		Password = password;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	@Override
	public String toString() {
		return String.format("O aluno '%s' foi cadastrado com o e-mail '%s' e com a senha '%s'", this.Name, this.Email, this.Password) ;
	}	
}
