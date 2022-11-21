package ir.isc.assignment.reopsitory;

import ir.isc.assignment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNationalNumber(String nationalNumber);
}
