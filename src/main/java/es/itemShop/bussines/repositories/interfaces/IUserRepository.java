package es.itemShop.bussines.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.itemShop.bussines.model.UserDao;

@Repository
public interface IUserRepository extends JpaRepository<UserDao, Long> {
}