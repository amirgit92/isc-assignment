package ir.isc.assignment.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cardType", "customer_id", "issuer_id"})})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String cardNumber;
    private CardType cardType;
    private String expireDate;
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "issuer_id", nullable = false)
    private Issuer issuer;
}
