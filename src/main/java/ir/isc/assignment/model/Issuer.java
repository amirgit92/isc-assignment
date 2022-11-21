package ir.isc.assignment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String issuerName;
    private String issuerNumber;

    @OneToMany(mappedBy = "issuer")
    List<Card> cards;

    public Issuer(String issuerName, String issuerNumber) {
        this.issuerName = issuerName;
        this.issuerNumber = issuerNumber;
    }
}
