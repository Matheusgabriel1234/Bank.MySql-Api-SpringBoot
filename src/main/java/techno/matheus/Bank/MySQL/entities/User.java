package techno.matheus.Bank.MySQL.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import techno.matheus.Bank.MySQL.enums.UserType;


@Entity
@Table(name = "tb_users")
public class User implements Serializable{
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank
private String firstName;
@NotBlank
private String lastName;

@Enumerated(EnumType.STRING)
private UserType userType;
private BigDecimal balance;

@Column(unique = true)

private String document;


@OneToMany(mappedBy = "senderId",cascade = CascadeType.ALL)
private List<Transfer> senderTransfer;


@OneToMany(mappedBy = "receiverId", cascade = CascadeType.ALL)
private List<Transfer> receiverTransfer;


public User() {
	
}



public User(@NotBlank String firstName, @NotBlank String lastName, UserType userType, BigDecimal balance,
		String document, List<Transfer> senderTransfer, List<Transfer> receiverTransfer) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userType = userType;
	this.balance = balance;
	this.document = document;
	this.senderTransfer = senderTransfer;
	this.receiverTransfer = receiverTransfer;
}





public BigDecimal getBalance() {
	return balance;
}



public void setBalance(BigDecimal balance) {
	this.balance = balance;
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



public String getDocument() {
	return document;
}

public void setDocument(String document) {
	this.document = document;
}



public List<Transfer> getSenderTransfer() {
	return senderTransfer;
}



public void setSenderTransfer(List<Transfer> senderTransfer) {
	this.senderTransfer = senderTransfer;
}



public List<Transfer> getReceiverTransfer() {
	return receiverTransfer;
}



public void setReceiverTransfer(List<Transfer> receiverTransfer) {
	this.receiverTransfer = receiverTransfer;
}



public void decreaseBalance(BigDecimal amount) {
this.balance = this.balance.subtract(amount);
}

public void increaseBalance(BigDecimal amount) {
this.balance = this.balance.add(amount);
}



@Override
public int hashCode() {
	return Objects.hash(id);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(id, other.id);
}





}
