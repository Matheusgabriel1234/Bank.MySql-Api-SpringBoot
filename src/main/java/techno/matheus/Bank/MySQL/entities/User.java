package techno.matheus.Bank.MySQL.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import techno.matheus.Bank.MySQL.enums.UserType;


@Entity
@Table(name = "tb_users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String firstName;
private String lastName;
private UserType userType;
private BigDecimal amount;
private String document;


@OneToMany(mappedBy = "senderId",cascade = CascadeType.ALL)
private List<Transfer> transfer;

public User() {
	
}

public User(Long id, String firstName, String lastName, BigDecimal amount, String document, List<Transfer> transfer) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.amount = amount;
	this.document = document;
	this.transfer = transfer;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public UserType getUserType() {
	return userType;
}

public void setUserType(UserType userType) {
	this.userType = userType;
}

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public String getDocument() {
	return document;
}

public void setDocument(String document) {
	this.document = document;
}

public List<Transfer> getTransfer() {
	return transfer;
}

public void setTransfer(List<Transfer> transfer) {
	this.transfer = transfer;
}





}
