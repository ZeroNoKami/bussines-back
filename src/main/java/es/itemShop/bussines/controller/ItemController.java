package es.itemShop.bussines.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.itemShop.bussines.model.ItemDao;
import es.itemShop.bussines.services.ItemService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
	// Lista de ItemDao
	@GetMapping("/list")
	public List<ItemDao> showItemList() {
		return itemService.findAllItem();
	} 
 

	// Mostrar un Item 
	@GetMapping("/view/{id}")
	public ItemDao showItem(@PathVariable Integer id) {
		return itemService.findItemById(id);
	}

	// Borrado lógico, cambiar estado
	@PutMapping(path = "/deactiState/{id}/{state}", headers="Accept=application/json")
	public ResponseEntity<?> deactivateState(@PathVariable Integer id, @PathVariable Integer state) {
		return itemService.deactivateState(id, state);
	}

	// Crear nuevo Item 
	@PostMapping(path = "/new", headers="Accept=application/json")
	public ItemDao createItem(@RequestBody ItemDao itemBody, HttpServletResponse response) {
		return itemService.newItem(itemBody, response);
	}
	
	// Editar Item 
	@PutMapping(path = "/edit/{id}", headers="Accept=application/json")
	public ItemDao editItem(@PathVariable(value = "id") Long id, @RequestBody ItemDao itemBody, HttpServletResponse response) {
		return itemService.editItem(id, itemBody, response);
	}

}
