package techno.matheus.Bank.MySQL.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import techno.matheus.Bank.MySQL.entities.Transfer;
import techno.matheus.Bank.MySQL.enums.UserType;

public record UserDTO(Long id,String firstName,String lastName,UserType userType,BigDecimal balance,String document,List<Transfer> senderTransfer,List<Transfer> receiverTransfer) {

}
