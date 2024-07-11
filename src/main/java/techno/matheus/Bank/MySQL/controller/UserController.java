package techno.matheus.Bank.MySQL.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import techno.matheus.Bank.MySQL.entities.User;
import techno.matheus.Bank.MySQL.services.UserServices;


@RestController
@RequestMapping
public class UserController {
private UserServices services;

public UserController(UserServices services) {
this.services = services;
}

public ResponseEntity<List<User>> getAll(){
List<User> obj = services.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);
}

public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
Optional<User> obj = services.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
		
 }





}
