package es.itemShop.bussines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "suppliers")
public class SupplierDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_supplier")
	private Long id_supplier;
	@Column(name = "name_supplier")
	private String name_supplier;
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private CountryDao country;
	
	//----- GETTERS Y SETTERS -----//
    // ID SUPPLIER
	public Long getId_supplier() {
		return id_supplier;
	}
	public void setId_supplier(Long id_supplier) {
		this.id_supplier = id_supplier;
	}
	
	// NAME SUPPLIER
	public String getName_supplier() {
		return name_supplier;
	}
	public void setName_supplier(String name_supplier) {
		this.name_supplier = name_supplier;
	}
	
	// COUNTRY
	public CountryDao getCountry() {
		return country;
	}
	public void setCountry(CountryDao country) {
		this.country = country;
	}

	



}
