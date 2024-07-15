package techno.matheus.Bank.MySQL.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import techno.matheus.Bank.MySQL.dto.UserDTO;
import techno.matheus.Bank.MySQL.entities.User;
import techno.matheus.Bank.MySQL.repositories.UserRepository;


@Service
public class UserServices {

	private UserRepository repository;

	public UserServices(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	
public User convertToEntity(UserDTO userDto) {
	User user = new User();
	user.setFirstName(userDto.firstName());
	user.setLastName(userDto.lastName());
	user.setDocument(userDto.document());
	user.setBalance(userDto.balance());
	user.setUserType(userDto.userType());
	return user;
	
	
}

public UserDTO convertToDto(User user) {
	UserDTO dto = new UserDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getUserType(),user.getBalance(),user.getDocument(),user.getSenderTransfer(),user.getReceiverTransfer());
	return dto;
	
}
	
	
public List<UserDTO> getAll(){
return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());

   }

public Optional<User> getById(Long id) {
return repository.findById(id);
}

public List<UserDTO> create(UserDTO userDTO){
User user = convertToEntity(userDTO);
repository.save(user);
return getAll();
}

public List<UserDTO> update(Long id, UserDTO user){
Optional<User> userId = repository.findById(id);
if(userId.isPresent()) {
	User newUser = new User();
	newUser.setUserType(user.userType());
	newUser.setFirstName(user.firstName());
	newUser.setDocument(user.lastName());
	newUser.setDocument(user.document());
	newUser.setBalance(user.balance());
    
}
  return getAll();

}

public List<UserDTO> delete(Long id){

repository.deleteById(id);
return getAll();
	
}
	
	
}
