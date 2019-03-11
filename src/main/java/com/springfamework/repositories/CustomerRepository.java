package com.springfamework.repositories;

import com.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RK
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
