package es.itemShop.bussines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_country")
	private Long id_country;
	@Column(name = "name_country")
	private String name_country;
	
	//----- GETTERS Y SETTERS -----//
	// ID COUNTRY
	public Long getId_country() {
		return id_country;
	}
	public void setId_country(Long id_country) {
		this.id_country = id_country;
	}
	// NAME COUNTRY
	public String getName_country() {
		return name_country;
	}
	public void setName_country(String name_country) {
		this.name_country = name_country;
	}
  

	
}

