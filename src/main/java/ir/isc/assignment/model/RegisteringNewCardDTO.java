package ir.isc.assignment.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisteringNewCardDTO {
    CardType cardType;
    String issuerName;
    String ownerNationalNumber;
}
