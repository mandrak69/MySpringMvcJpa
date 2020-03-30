package rs.engineering.javacourse.myspringmvcapp.model;

public class UserCreateDto implements DTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	  private String email;
	  
	  public UserCreateDto(){}
	 
	  public UserCreateDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
	   return name;
	  }
	 
	  public void setName(String name) {
	   this.name = name;
	  }
	 
	  public String getEmail() {
	   return email;
	  }
	 
	  public void setEmail(String email) {
	   this.email = email;
	  }

	@Override
	public String toString() {
		return "UserCreateDTO [name=" + name + ", email=" + email + "]";
	}
	  
}
