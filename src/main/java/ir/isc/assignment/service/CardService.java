package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardService {
    CardDTO getCard(String cardNumber);
    Card newCard(Card newCard) throws Exception;
}
