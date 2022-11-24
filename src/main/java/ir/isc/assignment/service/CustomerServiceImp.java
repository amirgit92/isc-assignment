package ir.isc.assignment.service;

import ir.isc.assignment.controller.CardController;
import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.Customer;
import ir.isc.assignment.reopsitory.CardRepository;
import ir.isc.assignment.reopsitory.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> getCustomerCards(String nationalNumber) throws Exception {
        Customer customer = customerRepository.findByNationalNumber(nationalNumber);
        if (customer == null) {
            logger.warn("customer not found");
            throw new Exception("customer not found");
        }

        List<Card> cards = cardRepository.findByOwner(customer);
        if (cards.toArray().length == 0) {
            logger.warn("no cards exists for given national number");
            throw new Exception("no cards found");
        }
        return cards;
    }
}
