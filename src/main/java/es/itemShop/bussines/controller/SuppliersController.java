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

import es.itemShop.bussines.model.SupplierDao;
import es.itemShop.bussines.services.SuppliersService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/supplier")
public class SuppliersController {
	
	@Autowired
	private final SuppliersService supplierService;

    public SuppliersController(SuppliersService supplierService) {
        this.supplierService = supplierService;
    }
    
	// Lista de SuppliersDao
	@GetMapping("/list")
	public List<SupplierDao> showSuppliersList() {
		return supplierService.findAllSupplier();
	} 
 

	// Mostrar un proovedores 
	@GetMapping("/view/{id}")
	public SupplierDao showSuppliers(@PathVariable Integer id) {
		return supplierService.findSupplierById(id);
	}

	@DeleteMapping(value = "/erase/{id}")
	public ResponseEntity<?> eraseSuppliers(@PathVariable Integer id) {
		return supplierService.eraseSupplier(id);
	}

	// Crear nuevo proovedores 
	@PostMapping(path = "/new", headers="Accept=application/json")
	public SupplierDao createSuppliers(@RequestBody SupplierDao personaBody, HttpServletResponse response) {
		return supplierService.newSupplier(personaBody, response);
	}

	// Actualizar proovedores
	@PutMapping(path = "/update/{id}", headers="Accept=application/json")
	public ResponseEntity<?> editSuppliers(@PathVariable(value = "id") Integer id,
			RequestEntity<SupplierDao> reqPersonajes) {
		return supplierService.updateSupplier(id, reqPersonajes.getBody());
	}
}
