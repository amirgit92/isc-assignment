package ir.isc.assignment.controller;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardDTO;
import ir.isc.assignment.model.RegisteringNewCardDTO;
import ir.isc.assignment.service.CardService;
import ir.isc.assignment.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/card")
public class CardController {
    private static final Logger logger = LoggerFactory.getLogger(CardController.class);
    @Autowired
    CardService cardService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/get")
    private ResponseEntity<?> getCard(@RequestParam String cardNumber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cardService.getCard(cardNumber));
        } catch (Exception e) {
            logger.error(("card number validation error"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("card number is not valid");
        }
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getCustomerCards(@RequestParam String nationalNumber) {
        try {
            List<Card> cards = customerService.getCustomerCards(nationalNumber);
            List<CardDTO> cardDTOS = cards.stream().map(card->modelMapper.map(card,CardDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(cardDTOS);
        } catch (Exception e) {
            logger.error(("national number validation error"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("national number is not valid");
        }
    }

    @PostMapping("/new")
    private ResponseEntity<?> newCard(@RequestBody RegisteringNewCardDTO registeringNewCardDTO) throws Exception {
        try {
            Card newCard = modelMapper.map(registeringNewCardDTO,Card.class);
            newCard = cardService.newCard(newCard);
            CardDTO cardDto = modelMapper.map(newCard, CardDTO.class);
            return ResponseEntity.status(HttpStatus.OK).body(cardDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("card creation failed!");
        }
    }
}
