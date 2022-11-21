package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.Customer;
import ir.isc.assignment.reopsitory.CardRepository;
import ir.isc.assignment.reopsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> getCustomerCards(String nationalNumber) {
        Customer customer = customerRepository.findByNationalNumber(nationalNumber);
        List<Card> cards = cardRepository.findByOwner(customer);
        return cards;
    }

    @Override
    public Customer getCustomer(String nationalNumber) {
        return customerRepository.findByNationalNumber(nationalNumber);
    }

    @Override
    public Customer newCustomer(String nationalNumber, String firstName, String lastName, String phoneNumber, String address, String accountNumber) {
        Customer newCustomer = new Customer(nationalNumber, firstName, lastName, phoneNumber, address, accountNumber);
        return customerRepository.save(newCustomer);

    }
}
