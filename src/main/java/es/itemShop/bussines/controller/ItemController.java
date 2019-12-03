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

	@DeleteMapping(value = "/erase/{id}")
	public ResponseEntity<?> eraseItem(@PathVariable Integer id) {
		return itemService.eraseItem(id);
	}

	// Crear nuevo Item 
	@PostMapping(path = "/new", headers="Accept=application/json")
	public ItemDao createItem(@RequestBody ItemDao personaBody, HttpServletResponse response) {
		return itemService.newItem(personaBody, response);
	}

	// Actualizar Item
	@PutMapping(path = "/update/{id}", headers="Accept=application/json")
	public ResponseEntity<?> editItem(@PathVariable(value = "id") Integer id,
			RequestEntity<ItemDao> reqPersonajes) {
		return itemService.updateItem(id, reqPersonajes.getBody());
	}
}
