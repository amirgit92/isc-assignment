package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardService {
    Card getCard(String cardNumber);
//    List<Card> getAllCards(String cardNumber);
//    Card newCard(String cardNumber, CardType type, LocalDate expireDate, boolean active, Customer owner, Issuer issuer);
    Card newCard(Card newCard);
}
