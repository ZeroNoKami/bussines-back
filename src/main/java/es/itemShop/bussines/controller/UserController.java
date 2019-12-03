package es.itemShop.bussines.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.itemShop.bussines.model.UserDao;
import es.itemShop.bussines.services.UserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController{

	@Autowired
	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
	// Lista de usuarios
	@GetMapping("/list")
	public List<UserDao> showUserList() {
		return userService.findAllUser();
	} 
 

	// Mostrar un usuario
	@GetMapping("/view/{id}")
	public UserDao showUser(@PathVariable Integer id) {
		return userService.findUserById(id);
	}

	@DeleteMapping(value = "/erase/{id}")
	public ResponseEntity<?> eraseUser(@PathVariable Integer id) {
		return userService.eraseUser(id);
	}

	// Crear nuevo usuario
	@PostMapping(path = "/new", headers="Accept=application/json")
	public UserDao createUser(@RequestBody UserDao personaBody, HttpServletResponse response) {
		return userService.newUser(personaBody, response);
	}

	// Actualizar usuario
	@PutMapping(path = "/update/{id}", headers="Accept=application/json")
	public ResponseEntity<?> editUser(@PathVariable(value = "id") Integer id,
			RequestEntity<UserDao> reqPersonajes) {
		return userService.updateUser(id, reqPersonajes.getBody());
	}
		
}
