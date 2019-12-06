package es.itemShop.bussines.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.itemShop.bussines.model.SupplierDao;
import es.itemShop.bussines.repositories.interfaces.ISupplierRepository;


@Service
public class SuppliersService {

	    @Autowired
		private final ISupplierRepository repoSupplier;

	    public SuppliersService(ISupplierRepository repoSupplier){
	        this.repoSupplier = repoSupplier;
	    }
	    
	    // Busqueda de todos los Proveedores 
	    public List<SupplierDao> findAllSupplier(){
	        return repoSupplier.findAll();
	    }
	    
	    // Busqueda de un proveedor por su ID
	    public SupplierDao findSupplierById(Integer id){    
	        return repoSupplier.findById(Long.valueOf(id)).get();
	    }

}
