package techno.matheus.Bank.MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import techno.matheus.Bank.MySQL.entities.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
