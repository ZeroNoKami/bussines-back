package es.itemShop.bussines.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.itemShop.bussines.model.SupplierDao;

@Repository
public interface ISupplierRepository extends JpaRepository<SupplierDao, Long> {
	

}
