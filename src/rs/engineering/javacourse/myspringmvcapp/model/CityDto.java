package rs.engineering.javacourse.myspringmvcapp.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CityDto  implements DTO {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Morete uneti ptt broj")
	private Long number;
	@NotEmpty(message = "Morate uneti ime")
	private String name;
	
	public CityDto() {
	}
	
	public CityDto(Long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CCityDto [number=" + number + ", name=" + name + "]";
	}
	
}
