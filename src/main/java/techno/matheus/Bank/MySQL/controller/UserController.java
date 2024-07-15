package techno.matheus.Bank.MySQL.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import techno.matheus.Bank.MySQL.dto.UserDTO;
import techno.matheus.Bank.MySQL.entities.User;
import techno.matheus.Bank.MySQL.services.UserServices;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/users")
public class UserController {
private UserServices services;

public UserController(UserServices services) {
this.services = services;
}


@GetMapping
public ResponseEntity<List<UserDTO>> getAll(){
List<UserDTO> obj = services.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
Optional<User> obj = services.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<List<UserDTO>> create(@RequestBody UserDTO user){
List<UserDTO> obj = services.create(user);
return new ResponseEntity<>(obj,HttpStatus.CREATED);


}


@PutMapping("/{id}")
public ResponseEntity<List<UserDTO>> update(@PathVariable UserDTO user,Long id){
	List<UserDTO> obj = services.update(id, user);
	return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}


@DeleteMapping("/{id}")
public ResponseEntity<List<UserDTO>> delete(@PathVariable Long id){
	List<UserDTO> obj = services.delete(id);
	return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
}



}
