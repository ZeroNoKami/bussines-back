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

	    // Creacion de un nuevo proveedor
	    public SupplierDao newSupplier(SupplierDao personaBody, HttpServletResponse response){
	    	SupplierDao personaje = personaBody;
			response.setStatus(201);
			return repoSupplier.save(personaje);
	    }

	    // Borrado de un proveedor por ID
	    public ResponseEntity<?> eraseSupplier(Integer id){
	        Optional<SupplierDao> personaje = repoSupplier.findById(Long.valueOf(id));

			if (personaje.isPresent()) {
				repoSupplier.delete(personaje.get());
				return new ResponseEntity<SupplierDao>(personaje.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("El personaje no existe", HttpStatus.NOT_FOUND);
			}
	    }

	    // Actualizado de un proveedor por ID
	    public ResponseEntity<?> updateSupplier(Integer id, SupplierDao personaje){
	        if (personaje == null) {
				return new ResponseEntity<String>("No ha ingresado ningun campo.", HttpStatus.BAD_REQUEST);
			}
		
			if (repoSupplier.findById(Long.valueOf(id)).isPresent()) {
				SupplierDao newPersonajes = tituloSinCamposNulls(personaje, repoSupplier.findById(Long.valueOf(id)).get());
				return new ResponseEntity<SupplierDao>(repoSupplier.save(newPersonajes), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se ha encontrado", HttpStatus.NOT_FOUND);
			}
	    }

	    // Metodo auxiliar para evitar updates con nulls
	    private SupplierDao tituloSinCamposNulls(SupplierDao newSupplier, SupplierDao oldSupplier) {
	        
//	        if(newSupplier.getDescription()!=null)
//	            oldSupplier.setDescription(newSupplier.getDescription());
//	        if(newSupplier.getPrice()!=null)
//	            oldSupplier.setPrice(newSupplier.getPrice());
//	        if(newSupplier.getPrice_reduccion()!=null)
//	            oldSupplier.setPrice_reduccion(newSupplier.getPrice_reduccion());
//	        if(newSupplier.getState()!=null)
//	            oldSupplier.setState(newSupplier.getState());
//	        if(newSupplier.getSuppliers()!=null)
//	            oldSupplier.setSuppliers(newSupplier.getSuppliers());
//	        if(newSupplier.getCreation_date()!=null)
//	            oldSupplier.setCreation_date(newSupplier.getCreation_date());
//	        if(newSupplier.getCreation_user()!=null)
//	            oldSupplier.setCreation_user(newSupplier.getCreation_user());  
	        return oldSupplier;
	    }    


		
	
}
