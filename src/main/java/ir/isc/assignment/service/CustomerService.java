package ir.isc.assignment.service;

import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.Customer;
import java.util.List;
public interface CustomerService {
    List<Card> getCustomerCards(String nationalNumber) throws Exception;
}
