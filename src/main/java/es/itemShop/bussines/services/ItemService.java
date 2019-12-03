package es.itemShop.bussines.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.itemShop.bussines.model.ItemDao;
import es.itemShop.bussines.repositories.interfaces.IItemRepository;


@Service
public class ItemService {

	    @Autowired
		private final IItemRepository repoItem;

	    public ItemService(IItemRepository repoItem){
	        this.repoItem = repoItem;
	    }
	    
	    // Busqueda de todos los Items 
	    public List<ItemDao> findAllItem(){
	        return repoItem.findAll();
	    }
	    
	    // Busqueda de un item por su ID
	    public ItemDao findItemById(Integer id){    
	        return repoItem.findById(Long.valueOf(id)).get();
	    }

	    // Creacion de un nuevo item
	    public ItemDao newItem(ItemDao personaBody, HttpServletResponse response){
	    	ItemDao personaje = personaBody;
			response.setStatus(201);
			return repoItem.save(personaje);
	    }

	    // Borrado de un item por ID
	    public ResponseEntity<?> eraseItem(Integer id){
	        Optional<ItemDao> personaje = repoItem.findById(Long.valueOf(id));

			if (personaje.isPresent()) {
				repoItem.delete(personaje.get());
				return new ResponseEntity<ItemDao>(personaje.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("El personaje no existe", HttpStatus.NOT_FOUND);
			}
	    }

	    // Actualizado de un item por ID
	    public ResponseEntity<?> updateItem(Integer id, ItemDao personaje){
	        if (personaje == null) {
				return new ResponseEntity<String>("No ha ingresado ningun campo.", HttpStatus.BAD_REQUEST);
			}
		
			if (repoItem.findById(Long.valueOf(id)).isPresent()) {
				ItemDao newPersonajes = tituloSinCamposNulls(personaje, repoItem.findById(Long.valueOf(id)).get());
				return new ResponseEntity<ItemDao>(repoItem.save(newPersonajes), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se ha encontrado", HttpStatus.NOT_FOUND);
			}
	    }

	    // Metodo auxiliar para evitar updates con nulls
	    private ItemDao tituloSinCamposNulls(ItemDao newItem, ItemDao oldItem) {
	        
//	        if(newItem.getDescription()!=null)
//	            oldItem.setDescription(newItem.getDescription());
//	        if(newItem.getPrice()!=null)
//	            oldItem.setPrice(newItem.getPrice());
//	        if(newItem.getPrice_reduccion()!=null)
//	            oldItem.setPrice_reduccion(newItem.getPrice_reduccion());
//	        if(newItem.getState()!=null)
//	            oldItem.setState(newItem.getState());
//	        if(newItem.getCreation_date()!=null)
//	            oldItem.setCreation_date(newItem.getCreation_date());
//	        if(newItem.getCreation_user()!=null)
//	            oldItem.setCreation_user(newItem.getCreation_user());  
	        return oldItem;
	    }    


		
	
}
