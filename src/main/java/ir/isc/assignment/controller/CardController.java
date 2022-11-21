package ir.isc.assignment.controller;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.service.CardService;
import ir.isc.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/card")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/get")
    private ResponseEntity<?> getCard(@RequestParam String cardNumber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cardService.getCard(cardNumber));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("card number is not valid");
        }
    }

    @GetMapping("/get-all")
    private ResponseEntity<?> getCustomerCards(@RequestParam String nationalNumber) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerCards(nationalNumber));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("national number is not valid");
        }
    }

    @PostMapping("/new")
    private ResponseEntity<?> newCard(@RequestBody Card newCard) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cardService.newCard(newCard));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something wrong happened, please try again later");
        }
    }
}