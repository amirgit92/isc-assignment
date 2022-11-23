package ir.isc.assignment.reopsitory;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByOwner(Customer owner);

    Card findByCardNumber(String cardNumber);

}
