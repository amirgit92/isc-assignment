package ir.isc.assignment.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

//@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cardNumber;

    private CardType cardType;
    private LocalDate expireDate;
    private boolean isActive;

    @Transient
    private String issuerNumber;
    @Transient
    private String issuerName;
    @Transient
    private String cardOwnerFirstName;
    @Transient
    private String cardOwnerLastName;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)

    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "issuer_id", nullable = false)

    private Issuer issuer;
}
