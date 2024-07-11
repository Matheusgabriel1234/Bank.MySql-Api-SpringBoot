package techno.matheus.Bank.MySQL.services;

import java.util.List;
import java.util.Optional;

import techno.matheus.Bank.MySQL.entities.User;
import techno.matheus.Bank.MySQL.repositories.UserRepository;

public class UserServices {

	private UserRepository repository;

	public UserServices(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
public List<User> getAll(){
return repository.findAll();
   }

public Optional<User> getById(Long id) {
return repository.findById(id);
}

public List<User> create(User user){
repository.save(user);
return getAll();
}

public List<User> update(Long id, User user){
Optional<User> userId = repository.findById(id);
if(userId.isPresent()) {
	User newUser = new User();
	newUser.setUserType(user.getUserType());
	newUser.setFirstName(user.getFirstName());
	newUser.setDocument(user.getLastName());
	newUser.setDocument(user.getDocument());
	newUser.setAmount(user.getAmount());
    
}
  return getAll();

}

public List<User> delete(Long id){
repository.deleteById(id);
return getAll();
	
}
	
	
}
