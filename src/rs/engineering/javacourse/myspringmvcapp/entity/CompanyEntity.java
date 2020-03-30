package rs.engineering.javacourse.myspringmvcapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.getAll",query = "SELECT c FROM CompanyEntity c"),
    @NamedQuery(name = "Company.getByName",query = "SELECT u from CompanyEntity u where u.Id = :Id ")
})
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private String address;
	private String number;
	private CityEntity cityEntity;

	public CompanyEntity() {
	}

	@Override
	public String toString() {
		return "CompanyEntity [Id=" + Id + ", name=" + name + ", address=" + address + ", number=" + number
				+ ", cityEntity=" + cityEntity + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public CityEntity getCityEntity() {
		return cityEntity;
	}

	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}

	public CompanyEntity(long id, String name, String address, String number, CityEntity cityEntity) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityEntity = cityEntity;
	}

	public CompanyEntity(String name, String address, String number, CityEntity cityEntity) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityEntity = cityEntity;
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

}
