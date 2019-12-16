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

	// Mostrar un usuario
	@GetMapping("/view/{id}")
	public UserDao showUser(@PathVariable Integer id) {
		return userService.findUserById(id);
	}

}
