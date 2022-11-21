package ir.isc.assignment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public class CardInfo {
    private String cardNumber;
    private CardType cardType;
    private LocalDate expireDate;
    private boolean isActive;
    private String issuerNumber;
    private String issuerName;
    private String cardOwnerFirstName;
    private String cardOwnerLastName;
}
