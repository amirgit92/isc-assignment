package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardDTO;
import ir.isc.assignment.model.RegisteringNewCardDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CardService {
    CardDTO getCard(String cardNumber) throws Exception;
    Card newCard(Card newCard) throws Exception;
}
