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

@SpringBootApplication
public class AssignmentApplication {

    //declaring ModelMapper as a bean
//    @Bean
//    public ModelMapper modelMapper(){
//        return new ModelMapper();
//    }

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
        MemoryUsage memoryUsage = new MemoryUsage("memory usage thread");
        memoryUsage.start();
    }


    @Bean
    CommandLineRunner run(CardRepository cardRepository, CustomerRepository customerRepository, IssuerRepository issuerRepository) {
        return args -> {

//            Customer customer1 = new
//                    Customer("1450253698", "amir", "babazadeh", "09371234567", "someWhereOnTheEarth", "125478");

            Customer customer1 = Customer.builder()
                    .nationalNumber("1450543197")
                    .firstName("Amir")
                    .lastName("Babazadeh")
                    .phoneNumber("09371234567")
                    .address("somewhereOnTheEarth")
                    .accountNumber("125478")
                    .build();


//            Customer customer2 = new
//                    Customer("0053657894", "mina", "minaei", "09126352418", "anotherWhereOnTheEarth", "968574");

            Customer customer2 = Customer.builder()
                    .nationalNumber("0053657894")
                    .firstName("mina")
                    .lastName("minaei")
                    .phoneNumber("09126352418")
                    .address("anotherWhereOnTheEarth")
                    .accountNumber("968574")
                    .build();

            Issuer issuer1 = new Issuer("melli", "123456");
            Issuer issuer2 = new Issuer("mellat", "654321");

//            Card card1 = new Card("1234679", CardType.credit, setExpiryDate(), true, customer1, issuer1);
            Card card1 = Card.builder()
                    .cardNumber("123456789")
                    .cardType(CardType.credit)
                    .expireDate(setExpiryDate())
                    .isActive(true)
                    .owner(customer1)
                    .issuer(issuer1)
                    .build();

//            Card card2 = new Card("1452369", CardType.debit, setExpiryDate(), true, customer2, issuer2);
            Card card2 = Card.builder()
                    .cardNumber("147258369")
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

            cardRepository.save(card1);
            cardRepository.save(card2);

        };
    }

    private LocalDate setExpiryDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
        LocalDate currentDate = LocalDate.now();
        //expiry date after 5 years
        LocalDate expiryDate = currentDate.plusYears(5);
        return expiryDate;
    }


}
