package br.com.posprodutos.repository;

import br.com.posprodutos.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findCustomersByNameContainingIgnoreCase(String name);
    Optional<Customer> findFirstCustomerByName(String name);
    List<Customer> findCustomerByAddress_DistrictContainingIgnoreCase(String district);
    List<Customer> findCustomerByNameContainingIgnoreCaseAndAddress_DistrictContainingIgnoreCase(String name, String district);
}
