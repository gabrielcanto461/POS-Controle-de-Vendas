package br.com.posprodutos.usecases.client;

import br.com.posprodutos.dto.CustomerDTO;
import br.com.posprodutos.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindCustomerUseCasesImpl implements FindCustomerUseCases {

    private final CustomerRepository customerRepository;

    @Autowired
    public FindCustomerUseCasesImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAllClients() {
        var iterable = customerRepository.findAll();

        var list = new ArrayList<CustomerDTO>();
        iterable.forEach((client) -> list.add(new CustomerDTO(client)));

        return list;
    }

    @Override
    public List<CustomerDTO> findByDistrict(String district) {
        var customersList = customerRepository.findCustomerByAddress_DistrictContainingIgnoreCase(district);
        return customersList.stream()
                .map(CustomerDTO::new).toList();
    }

    @Override
    public List<CustomerDTO> findByName(String name) {
        var customersList = customerRepository.findCustomersByNameContainingIgnoreCase(name);
        return customersList.stream()
                .map(CustomerDTO::new).toList();
    }

    @Override
    public CustomerDTO findById(Long id) {
        var optionalCustomer = customerRepository.findById(id);

        return optionalCustomer.map(CustomerDTO::new).orElse(null);
    }

    @Override
    public List<CustomerDTO> findByNameAndDistrict(String name, String district) {
        var customersList = customerRepository.findCustomerByNameContainingIgnoreCaseAndAddress_DistrictContainingIgnoreCase(name, district);

        return customersList.stream()
                .map(CustomerDTO::new).toList();
    }


}
