package ir.isc.assignment.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nationalNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    @Column(unique = true)
    private String accountNumber;
    @OneToMany(mappedBy = "owner")
    private List<Card> cards;
    public Customer(String nationalNumber,String firstName,String lastName,String phoneNumber,String address,String accountNumber){
        this.nationalNumber = nationalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.accountNumber = accountNumber;
    }
}
