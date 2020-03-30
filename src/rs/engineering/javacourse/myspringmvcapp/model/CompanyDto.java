package rs.engineering.javacourse.myspringmvcapp.model;

import javax.validation.constraints.NotBlank;

public class CompanyDto implements DTO {
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Unesite ime")
	private String name;
	@NotBlank(message = "Unesite adresu")
	private String address;
	@NotBlank(message = "Unesite broj uluce")
	private String number;
	private CityDto cityDto;

	public CompanyDto() {
	}

	

	public CompanyDto( @NotBlank(message = "Unesite ime") String name,
			@NotBlank(message = "Unesite adresu") String address,
			@NotBlank(message = "Unesite broj uluce") String number, CityDto cityDto) {
		super();
		
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityDto = cityDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CityDto getCityDto() {
		return cityDto;
	}

	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}

	

	@Override
	public String toString() {
		return "CompanyDto [  name=" + name + ", address=" + address + ", number=" + number + ", cityDto="
				+ cityDto + "]";
	}

	

}
