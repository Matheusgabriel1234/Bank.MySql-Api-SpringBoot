package techno.matheus.Bank.MySQL.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_transfers")
public class Transfer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id;



@ManyToOne
@JoinColumn(name = "sender_id",nullable = true)
public User senderId;

@OneToOne
public User receiverid;



}
