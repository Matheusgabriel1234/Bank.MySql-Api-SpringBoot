package techno.matheus.Bank.MySQL.entities;



import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;


@Entity
@Table(name = "tb_transfers")
public class Transfer implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;



@ManyToOne
@JoinColumn(name = "sender_id",nullable = true)
private User senderId;

@ManyToOne
@JoinColumn(name = "receiver_id",nullable = true)
private User receiverId;

private BigDecimal amount;

public Transfer() {
	
}



public Transfer(Long id, User senderId, User receiverId, BigDecimal amount) {
	super();
	this.id = id;
	this.senderId = senderId;
	this.receiverId = receiverId;
	this.amount = amount;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public User getSenderId() {
	return senderId;
}

public void setSenderId(User senderId) {
	this.senderId = senderId;
}



public User getReceiverId() {
	return receiverId;
}



public void setReceiverId(User receiverId) {
	this.receiverId = receiverId;
}



public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}








}
