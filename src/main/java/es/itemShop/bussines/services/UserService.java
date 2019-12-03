package es.itemShop.bussines.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.itemShop.bussines.model.UserDao;
import es.itemShop.bussines.repositories.interfaces.IUserRepository;


@Service
public class UserService {

	    @Autowired
		private final IUserRepository repoUser;

	    public UserService(IUserRepository repoUser){
	        this.repoUser = repoUser;
	    }
	    
	    // Busqueda de todos los Users 
	    public List<UserDao> findAllUser(){
	        return repoUser.findAll();
	    }
	    
	    // Busqueda de un item por su ID
	    public UserDao findUserById(Integer id){    
	        return repoUser.findById(Long.valueOf(id)).get();
	    }

	    // Creacion de un nuevo item
	    public UserDao newUser(UserDao personaBody, HttpServletResponse response){
	    	UserDao personaje = personaBody;
			response.setStatus(201);
			return repoUser.save(personaje);
	    }

	    // Borrado de un item por ID
	    public ResponseEntity<?> eraseUser(Integer id){
	        Optional<UserDao> personaje = repoUser.findById(Long.valueOf(id));

			if (personaje.isPresent()) {
				repoUser.delete(personaje.get());
				return new ResponseEntity<UserDao>(personaje.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("El personaje no existe", HttpStatus.NOT_FOUND);
			}
	    }

	    // Actualizado de un item por ID
	    public ResponseEntity<?> updateUser(Integer id, UserDao personaje){
	        if (personaje == null) {
				return new ResponseEntity<String>("No ha ingresado ningun campo.", HttpStatus.BAD_REQUEST);
			}
		
			if (repoUser.findById(Long.valueOf(id)).isPresent()) {
				UserDao newPersonajes = tituloSinCamposNulls(personaje, repoUser.findById(Long.valueOf(id)).get());
				return new ResponseEntity<UserDao>(repoUser.save(newPersonajes), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se ha encontrado", HttpStatus.NOT_FOUND);
			}
	    }

  

	    // Metodo auxiliar para evitar updates con nulls
	    private UserDao tituloSinCamposNulls(UserDao newUser, UserDao oldUser) {
	        
//	        if(newUser.getDescription()!=null)
//	            oldUser.setDescription(newUser.getDescription());
//	        if(newUser.getPrice()!=null)
//	            oldUser.setPrice(newUser.getPrice());
//	        if(newUser.getPrice_reduccion()!=null)
//	            oldUser.setPrice_reduccion(newUser.getPrice_reduccion());
//	        if(newUser.getState()!=null)
//	            oldUser.setState(newUser.getState());
//	        if(newUser.getUsers()!=null)
//	            oldUser.setUsers(newUser.getUsers());
//	        if(newUser.getCreation_date()!=null)
//	            oldUser.setCreation_date(newUser.getCreation_date());
//	        if(newUser.getCreation_user()!=null)
//	            oldUser.setCreation_user(newUser.getCreation_user());  
	        return oldUser;
	    }    
		
	
}
