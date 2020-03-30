package rs.engineering.javacourse.myspringmvcapp.model;

public class UserReadDto implements DTO {
	 
	  private String name;
	  private String email;
	  
	  public UserReadDto(){}
	 
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
	 }