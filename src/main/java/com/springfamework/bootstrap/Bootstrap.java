package com.springfamework.bootstrap;

import com.springfamework.domain.Customer;
import com.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by RK
 */
@Component
public class Bootstrap implements CommandLineRunner{

   
    private final CustomerRepository customerRepository;


    public Bootstrap( CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;

    }

    @Override
    public void run(String... args) throws Exception {


        loadCustomers();

    }



    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFullName("Rabia");
        customer1.setEmail ("Rabia@gmail.com");
        customer1.setMobile ("+(1) 832-566-5567");
        customer1.setCity ("Houston");
        customer1.setDepartmentName("dep 1");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFullName("Muriel");
        customer2.setEmail ("Kabbaj@gmail.com");
        customer2.setMobile ("+(1) 832-566-5567");
        customer2.setCity ("Menziken");
        customer2.setDepartmentName("dep 2");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3l);
        customer3.setFullName("Anna");
        customer3.setEmail ("Westen@gmail.com");
        customer3.setMobile ("+(1) 832-566-5567");
        customer3.setCity ("Houston");
        customer3.setDepartmentName("dep 3");
        customerRepository.save(customer3);

        Customer customer4 = new Customer();
        customer4.setId(4l);
        customer4.setFullName("Adam");
        customer4.setEmail ("Smith@gmail.com");
        customer4.setMobile ("+(1) 832-566-5567");
        customer4.setCity ("New York");
        customer4.setDepartmentName("dep 4");
        customerRepository.save(customer4);

        Customer customer5 = new Customer();
        customer5.setId(5l);
        customer5.setFullName("John");
        customer5.setEmail ("Doe@gmail.com");
        customer5.setMobile ("+(1) 832-566-5567");
        customer5.setCity ("Los Angeles");
        customer5.setDepartmentName("dep 5");
        customerRepository.save(customer5);

        Customer customer6 = new Customer();
        customer6.setId(6l);
        customer6.setFullName("bob");
        customer6.setEmail ("Miller@gmail.com");
        customer6.setMobile ("+(1) 832-566-5567");
        customer6.setCity ("Portland");
        customer6.setDepartmentName("dep 6");
        customerRepository.save(customer6);




        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}
