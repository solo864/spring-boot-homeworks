package az.online.shop;


import az.online.shop.dao.CustomerRepository;
import az.online.shop.entity.Customer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.Commit;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println();


    }


    @Override
    @Commit
    public void run(String... args) throws Exception {
        Optional<Customer> customer = customerRepository.findById(1);
        customer.get().setPassword("privet kak tvoi dela sda");
    }
}