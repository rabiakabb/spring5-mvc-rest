package com.springfamework.services;

import com.springfamework.api.v1.mapper.CustomerMapper;
import com.springfamework.api.v1.model.CustomerDTO;
import com.springfamework.controllers.v1.CustomerController;
import com.springfamework.domain.Customer;
import com.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RK
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                   CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                   customerDTO.setCustomerUrl(getCustomerUrl(customer.getId()));
                   return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {

        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .map(customerDTO -> {
                    //set API URL
                    customerDTO.setCustomerUrl(getCustomerUrl(id));
                    return customerDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        return saveAndReturnDTO(customerMapper.customerDtoToCustomer(customerDTO));
    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setCustomerUrl(getCustomerUrl(savedCustomer.getId()));

        return returnDto;
    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);

        return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {

            if(customerDTO.getFullName() != null){
                customer.setFullName(customerDTO.getFullName());
            }

            if(customerDTO.getEmail () != null){
                customer.setEmail(customerDTO.getEmail());
            }

            if(customerDTO.getMobile() != null){
                customer.setMobile(customerDTO.getMobile());
            }

            if(customerDTO.getCity() != null){
                customer.setCity(customerDTO.getCity());
            }

            if(customerDTO.getDepartmentName() != null){
                customer.setDepartmentName(customerDTO.getDepartmentName());
            }


            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));

            returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }

    private String getCustomerUrl(Long id) {
        return CustomerController.BASE_URL + "/" + id;
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
