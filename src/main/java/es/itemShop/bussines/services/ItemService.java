package es.itemShop.bussines.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.itemShop.bussines.model.ItemDao;
import es.itemShop.bussines.repositories.interfaces.IItemRepository;
import es.itemShop.bussines.utils.Constantes;


@Service
public class ItemService {

	    @Autowired
		private final IItemRepository repoItem;
	    @Autowired
	    private UserService userService;
	    @Autowired
	    private SuppliersService supplierService;
	    @Autowired
	    private ReducedPriceService reducedPriceService;
	    
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
	    	ItemDao item = personaBody;
	    	item.setCreation_date(new Date());
	    	item.setPrice_reduccion(reducedPriceService.findReducedPriceById(1));
	    	item.setCreation_user(userService.findUserById(1));
	    	item.setSupplier(supplierService.findSupplierById(1));

			response.setStatus(201);
			return repoItem.save(item);
	    }

	    // Borrado de un item por ID
	    public ResponseEntity<?> eraseItem(Integer id){
	        Optional<ItemDao> item = repoItem.findById(Long.valueOf(id));

			if (item.isPresent()) {
				repoItem.delete(item.get());
				return new ResponseEntity<ItemDao>(item.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("El item no existe", HttpStatus.NOT_FOUND);
			}
	    }

	    // Actualizado de un item por ID
	    public ResponseEntity<?> updateItem(Integer id, ItemDao item){
	        if (item == null) {
				return new ResponseEntity<String>("No ha ingresado ningun campo.", HttpStatus.BAD_REQUEST);
			}
		
			if (repoItem.findById(Long.valueOf(id)).isPresent()) {
				return new ResponseEntity<ItemDao>(repoItem.save(item), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se ha encontrado", HttpStatus.NOT_FOUND);
			}
	    }

		public ResponseEntity<?> deactivateState(Integer id, Integer state) {
			ItemDao newItem =  repoItem.findById(Long.valueOf(id)).get();
			if (repoItem.findById(Long.valueOf(id)).isPresent()) {
				newItem.setState(Constantes.INACTIVO);				
				return new ResponseEntity<ItemDao>(repoItem.save(newItem), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No se ha encontrado", HttpStatus.NOT_FOUND);
			}
		}    
		
		public ItemDao editItem(Long id, ItemDao itemBody, HttpServletResponse response) {
			ItemDao oldItem =  repoItem.findById(Long.valueOf(id)).get();
			oldItem.setName_item(itemBody.getName_item()); 
			oldItem.setDescription(itemBody.getDescription());
			oldItem.setPrice(itemBody.getPrice()); 
			response.setStatus(200);
			return repoItem.save(oldItem);
			
		}
	
}
