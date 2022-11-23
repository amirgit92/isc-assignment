package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardDTO;
import ir.isc.assignment.model.Customer;
import ir.isc.assignment.model.Issuer;
import ir.isc.assignment.reopsitory.CardRepository;
import ir.isc.assignment.reopsitory.CustomerRepository;
import ir.isc.assignment.reopsitory.IssuerRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CardServiceImp implements CardService {
    private static final Logger logger = LoggerFactory.getLogger(CardServiceImp.class);
    @Autowired
    CardRepository cardRepository;
    @Autowired
    IssuerRepository issuerRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public CardDTO getCard(String cardNumber) throws Exception {
        Card card = cardRepository.findByCardNumber(cardNumber);
        if (card == null) {
            logger.warn(("card not found by card number"));
            throw new Exception("card not found!");
        }
        CardDTO cardDTO = modelMapper.map(card, CardDTO.class);
        return cardDTO;
    }

    // TODO: validating to be unique ard for unique customer
    @Override
    public Card newCard(Card card) throws Exception {
        String issuerName = card.getIssuer().getIssuerName();
        Issuer issuer = issuerRepository.findByIssuerName(issuerName);
        if (issuer == null) {
            logger.warn(("issuer not found "));
            throw new Exception("issuer not found!");
        }
        Customer owner = customerRepository.findByNationalNumber(card.getOwner().getNationalNumber());
        if (owner == null) {
            logger.warn(("owner not found "));
            throw new Exception("owner not found!");
        }

        String issuerNumber = issuer.getIssuerNumber();
        String cardNumber = issuerNumber + postfixCardNumberGenerator();
        Card newCard = Card.builder()
                .cardNumber(cardNumber)
                .isActive(true)
                .cardType(card.getCardType())
                .expireDate(setExpiryDate())
                .issuer(issuer)
                .owner(owner)
                .build();
        try {
            return cardRepository.save(newCard);
        } catch (Exception e) {
            logger.warn(("card creation "));
            throw new Exception("Card Creation failed!");
        }
    }

    private String setExpiryDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
        LocalDate currentDate = LocalDate.now();
        //expiry date after 5 years
        LocalDate expiryDate = currentDate.plusYears(5);
        return expiryDate.format(formatter);
    }

    //    generating 10 digit random number to be used in card number
    private long postfixCardNumberGenerator() {
        return (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
    }
}
