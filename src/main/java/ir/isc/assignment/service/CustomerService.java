package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.Customer;
import org.springframework.stereotype.Service;
import java.util.List;
public interface CustomerService {
    List<Card> getCustomerCards(String nationalNumber);

    Customer getCustomer(String nationalNumber);

    Customer newCustomer(String nationalNumber,String firstName,String lastName,String phoneNumber,String address,String accountNumber);
}