package ir.isc.assignment;

import ir.isc.assignment.memory_statistic.MemoryUsage;
import ir.isc.assignment.model.Card;
import ir.isc.assignment.model.CardType;
import ir.isc.assignment.model.Customer;
import ir.isc.assignment.model.Issuer;
import ir.isc.assignment.reopsitory.CardRepository;
import ir.isc.assignment.reopsitory.CustomerRepository;
import ir.isc.assignment.reopsitory.IssuerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
public class AssignmentApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
//        MemoryUsage memoryUsage = new MemoryUsage("memory usage thread");
//        memoryUsage.start();
    }

    @Bean
    CommandLineRunner run(CardRepository cardRepository, CustomerRepository customerRepository, IssuerRepository issuerRepository) {
        return args -> {

            Customer customer1 = Customer.builder()
                    .nationalNumber("1450543197")
                    .firstName("Amir")
                    .lastName("Babazadeh")
                    .phoneNumber("09371234567")
                    .address("somewhereOnTheEarth")
                    .accountNumber("125478")
                    .build();

            Customer customer2 = Customer.builder()
                    .nationalNumber("0053657894")
                    .firstName("mina")
                    .lastName("minaei")
                    .phoneNumber("09126352418")
                    .address("anotherWhereOnTheEarth")
                    .accountNumber("968574")
                    .build();

            Issuer issuer1 = new Issuer("melli", "111111");
            Issuer issuer2 = new Issuer("mellat", "222222");
            Issuer issuer3 = new Issuer("tejarat", "333333");
            Issuer issuer4 = new Issuer("sepah", "444444");

            Card card1 = Card.builder()
                    .cardNumber("1234561234567890")
                    .cardType(CardType.credit)
                    .expireDate(setExpiryDate())
                    .isActive(true)
                    .owner(customer1)
                    .issuer(issuer1)
                    .build();

            Card card2 = Card.builder()
                    .cardNumber("6543219876543210")
                    .cardType(CardType.credit)
                    .expireDate(setExpiryDate())
                    .isActive(true)
                    .owner(customer2)
                    .issuer(issuer2)
                    .build();

            customerRepository.save(customer1);
            customerRepository.save(customer2);

            issuerRepository.save(issuer1);
            issuerRepository.save(issuer2);
            issuerRepository.save(issuer3);
            issuerRepository.save(issuer4);

            cardRepository.save(card1);
            cardRepository.save(card2);

        };
    }

    private String setExpiryDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
        LocalDate currentDate = LocalDate.now();
        //expiry date after 5 years
        LocalDate expiryDate = currentDate.plusYears(5);
        return expiryDate.format(formatter);
    }


}
