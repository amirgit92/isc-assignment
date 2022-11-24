package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardDTO;

public interface CardService {
    CardDTO getCard(String cardNumber) throws Exception;
    Card newCard(Card newCard) throws Exception;
}
