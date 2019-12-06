package es.itemShop.bussines.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import es.itemShop.bussines.model.ReducedPriceDao;

	public interface IReducedPriceRepository extends JpaRepository<ReducedPriceDao, Long> {
}
