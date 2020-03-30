package rs.engineering.javacourse.myspringmvcapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "city")
@NamedQueries({
    @NamedQuery(name = "City.getAll",query = "SELECT c FROM CityEntity c"),
    @NamedQuery(name = "City.getByName",query = "SELECT u from CityEntity u where u.name = :name "),
    @NamedQuery(name = "City.getByNumber",query = "SELECT u from CityEntity u where u.number = :number ")
})
public class CityEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long number;
	
	private String name;
	
	public CityEntity() {
	}
	
	public CityEntity(Long number, String name) {
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
		return "City [number=" + number + ", name=" + name + "]";
	}
	
}
