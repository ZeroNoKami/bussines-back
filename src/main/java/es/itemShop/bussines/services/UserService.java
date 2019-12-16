package es.itemShop.bussines.services;

import org.springframework.beans.factory.annotation.Autowired;
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
	    
	    // Busqueda de un item por su ID
	    public UserDao findUserById(Integer id){    
	    	UserDao us = repoUser.findById(Long.valueOf(id)).get();
	        return us;
	    }

  
}
