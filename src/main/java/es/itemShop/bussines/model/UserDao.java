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
@Table(name = "users")
public class UserDao{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id_user;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@ManyToOne
    @JoinColumn(name = "rol_user", nullable = false)	
    private RolUserDao rol_user;
	
	//----- GETTERS Y SETTERS -----// 
	// ID USER
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	
	// NAME USER
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// ROL USER
	public RolUserDao getRol_user() {
		return rol_user;
	}
	public void setRol_user(RolUserDao rol_user) {
		this.rol_user = rol_user;
	}
			
}
