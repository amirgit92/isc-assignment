package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardInfo;
import ir.isc.assignment.model.Customer;
import ir.isc.assignment.model.Issuer;
import ir.isc.assignment.reopsitory.CardRepository;
import ir.isc.assignment.reopsitory.CustomerRepository;
import ir.isc.assignment.reopsitory.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
public class CardServiceImp implements CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    IssuerRepository issuerRepository;
    @Override
    public Card getCard(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber);

        //issuer is the Issuer type foreign key in card
        Optional<Issuer> issuer = Optional.ofNullable(card.getIssuer());

        //owner is the Customer type foreign key in card
        Optional<Customer> owner = Optional.ofNullable(card.getOwner());

        //fetching the owner of the card by id retrieved in above codes
        owner = customerRepository.findById(owner.get().getId());

        //fetching the issuer of the card by id retrieved in above codes
        issuer = issuerRepository.findById(issuer.get().getId());
/*
        CardInfo cardInfo = CardInfo.builder()
                .cardNumber(cardNumber)
                .cardType(card.getCardType())
                .expireDate(card.getExpireDate())
                .isActive(card.isActive())
                .issuerName(issuer.get().getIssuerName())
                .issuerNumber(issuer.get().getIssuerNumber())
                .cardOwnerFirstName(owner.get().getFirstName())
                .cardOwnerLastName(owner.get().getLastName())
                .build();
        */


//        card = new Card(cardNumber,card.getCardType(),card.getExpireDate(),card.isActive(),issuer.get().getIssuerNumber(),issuer.get().getIssuerName(),owner.get().getFirstName(),owner.get().getLastName());


        card = Card.builder()
                .cardNumber(cardNumber)
                .cardType(card.getCardType())
                .expireDate(card.getExpireDate())
                .isActive(card.isActive())
                .issuerName(issuer.get().getIssuerName())
                .issuerNumber(issuer.get().getIssuerNumber())
                .cardOwnerFirstName(owner.get().getFirstName())
                .cardOwnerLastName(owner.get().getLastName())
                .build();
        return card;
    }

    // TODO: validating to be unique ard for unique customer
    @Override
//    public Card newCard(String cardNumber, CardType type, LocalDate expireDate, boolean active, Customer owner, Issuer issuer) {
    public Card newCard(Card card) {

//        Card card = new Card(cardNumber, type, setExpiryDate(), active, owner, issuer);
//        Card card = Card.builder()
//                .cardNumber(cardNumber)
//                .cardType(type)
//                .expireDate(setExpiryDate())
//                .isActive(true)
//                .owner(owner)
//                .issuer(issuer)
//                .build();
        return cardRepository.save(card);
    }

    //calculating card expiry date
    private LocalDate setExpiryDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
        LocalDate currentDate = LocalDate.now();
        //expiry date after 5 years
        LocalDate expiryDate = currentDate.plusYears(5);
        return expiryDate;
    }
}
