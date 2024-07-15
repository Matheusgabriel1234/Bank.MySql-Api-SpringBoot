package techno.matheus.Bank.MySQL.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import techno.matheus.Bank.MySQL.entities.Transfer;
import techno.matheus.Bank.MySQL.entities.User;
import techno.matheus.Bank.MySQL.enums.UserType;
import techno.matheus.Bank.MySQL.repositories.TransferRepository;
import techno.matheus.Bank.MySQL.repositories.UserRepository;

@Service
public class TransferServices {
	
private TransferRepository repository;
private UserRepository userRepository;


	


public TransferServices(TransferRepository repository, UserRepository userRepository) {
	super();
	this.repository = repository;
	this.userRepository = userRepository;
}


public List<Transfer> getAll(){
return repository.findAll();
}


public Optional<Transfer> getById(Long id){
Optional<Transfer> obj = repository.findById(id);
return obj;
}

public List<Transfer> create(Transfer transfer){
User sender = transfer.getSenderId();
User receiver = transfer.getReceiverId();
BigDecimal amount = transfer.getAmount();

if(sender.getUserType() == UserType.MERCHANT) {
  throw new RuntimeErrorException(null, "Mercadores não podem fazer transferencias bancarias");
}

if(sender.getBalance().compareTo(amount) < 0) {
	throw new RuntimeErrorException(null,"Saldo não disponivel");
}

sender.decreaseBalance(amount);
receiver.increaseBalance(amount);

userRepository.save(sender);
userRepository.save(receiver);

repository.save(transfer);

return getAll();


}

public List<Transfer> delete(Long id){
repository.findById(id);
return getAll();
}




}
