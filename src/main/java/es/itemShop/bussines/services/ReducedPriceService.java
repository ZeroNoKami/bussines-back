package es.itemShop.bussines.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.itemShop.bussines.model.ReducedPriceDao;
import es.itemShop.bussines.repositories.interfaces.IReducedPriceRepository;


@Service
public class ReducedPriceService {

	    @Autowired
		private final IReducedPriceRepository repoReducedPrice;

	    public ReducedPriceService(IReducedPriceRepository repoReducedPrice){
	        this.repoReducedPrice = repoReducedPrice;
	    }
	    
	    // Busqueda de todos los Precio reducido 
	    public List<ReducedPriceDao> findAllReducedPrice(){
	        return repoReducedPrice.findAll();
	    }
	    
	    // Busqueda de un proveedor por su ID
	    public ReducedPriceDao findReducedPriceById(Integer id){    
	        return repoReducedPrice.findById(Long.valueOf(id)).get();
	    }
	
}
