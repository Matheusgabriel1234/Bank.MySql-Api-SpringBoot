package techno.matheus.Bank.MySQL.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import techno.matheus.Bank.MySQL.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
User findByDocument(String document);
boolean existsByDocument(String document);
}
