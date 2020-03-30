package rs.engineering.javacourse.myspringmvcapp.model;

public class UserUpdateDto implements DTO {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	public UserUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserUpdateDto(String firstname, String lastName, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserUpdateDto [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
