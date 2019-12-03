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
@Table(name = "item")
public class ItemDao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_item")
	private Long id_item;
	@Column(name = "name_item")
	private String name_item;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private Long price;
	@Column(name = "state")
	private Long state;
    @ManyToOne
    @JoinColumn(name = "supplier", nullable = false)
	private SupplierDao supplier;
    @ManyToOne
    @JoinColumn(name = "price_reduccion", nullable = false)
    private ReducedPriceDao price_reduccion;	
	@Column(name = "creation_date")
	private Long creation_date;
    @ManyToOne
    @JoinColumn(name = "creation_user", nullable = false)
    private UserDao creation_user;
	 
	//----- GETTERS Y SETTERS -----// 
	// ID ITEM
	public Long getId_item() {
		return id_item;
	}
	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}
	// NAME ITEM
	public String getName_item() {
		return name_item;
	}
	public void setName_item(String name_item) {
		this.name_item = name_item;
	}
	
	// DESCRIPTION
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// PRICE
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	// STATE
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	
	// SUPPLIERS
	public SupplierDao getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierDao supplier) {
		this.supplier = supplier;
	}
	
	// PRICE REDDUCCION
	public ReducedPriceDao getPrice_reduccion() {
		return price_reduccion;
	}
	
	public void setPrice_reduccion(ReducedPriceDao price_reduccion) {
		this.price_reduccion = price_reduccion;
	}
	
	// CREATION DATE
	public Long getCreation_date() {
		return creation_date;
	}
	
	public void setCreation_date(Long creation_date) {
		this.creation_date = creation_date;
	}
	
	// CREATION USER
	public UserDao getCreation_user() {
		return creation_user;
	}
	
	public void setCreation_user(UserDao creation_user) {
		this.creation_user = creation_user;
	}
			
}
