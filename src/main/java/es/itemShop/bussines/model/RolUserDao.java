package es.itemShop.bussines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rol_user")
public class RolUserDao{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long id_rol;
	@Column(name = "name_rol")
	private String name_rol;
	// 
	
	public Long getId_rol() {
		return id_rol;
	}
	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}
	public String getName_rol() {
		return name_rol;
	}
	public void setName_rol(String name_rol) {
		this.name_rol = name_rol;
	}

	
	
			
}
