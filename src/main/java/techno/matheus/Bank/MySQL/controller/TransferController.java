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

import techno.matheus.Bank.MySQL.entities.Transfer;
import techno.matheus.Bank.MySQL.services.TransferServices;

@RestController
@RequestMapping("/transfers")
public class TransferController {
	
private TransferServices service;

public TransferController(TransferServices service) {
	super();
	this.service = service;
}

@GetMapping
public ResponseEntity<List<Transfer>> getAll(){
List<Transfer> obj = service.getAll();
return new ResponseEntity<>(obj,HttpStatus.OK);

}

@GetMapping("/{id}")
public ResponseEntity<Optional<Transfer>> getById(@PathVariable Long id){
Optional<Transfer> obj = service.getById(id);
return new ResponseEntity<>(obj,HttpStatus.OK);
}

@PostMapping
public ResponseEntity<List<Transfer>> create(@RequestBody Transfer transfer){
List<Transfer> obj = service.create(transfer);
return new ResponseEntity<>(obj, HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
public ResponseEntity<List<Transfer>> delete(@PathVariable Long id){
List<Transfer> obj = service.delete(id);
return new ResponseEntity<> (obj,HttpStatus.ACCEPTED);
}



}
