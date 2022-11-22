package ir.isc.assignment.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CardDTO {
    private String cardNumber;
    private CardType cardType;
    private String expireDate;
    private boolean isActive;
    private String issuerNumber;
    private String issuerName;
    private String ownerFirstName;
    private String ownerLastName;
}
