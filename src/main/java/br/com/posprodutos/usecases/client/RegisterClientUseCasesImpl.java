package br.com.posprodutos.usecases.client;

import br.com.posprodutos.dto.CustomerDTO;
import br.com.posprodutos.model.Customer;
import br.com.posprodutos.repository.AccountRepository;
import br.com.posprodutos.repository.AddressRepository;
import br.com.posprodutos.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterClientUseCasesImpl implements RegisterClientUseCases {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public RegisterClientUseCasesImpl(CustomerRepository customerRepository, AddressRepository addressRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public CustomerDTO registerClient(Customer customer) {
        if (customerRepository.findFirstCustomerByName(customer.getName()).isPresent() && containsDistrict(customer)) {
            return null;
        }
        var account = customer.getAccount();
        if (account.getAccountNumber() == null || !accountRepository.existsById(account.getAccountNumber())) {
            accountRepository.save(customer.getAccount());
        }
        var address = customer.getAddress();
        if (address.getAddressId() == null || !addressRepository.existsById(address.getAddressId())) {
            addressRepository.save(address);
        }

        return new CustomerDTO(customerRepository.save(customer));
    }

    private Boolean containsDistrict(Customer customer) {
        return !customerRepository.findCustomerByAddress_DistrictContainingIgnoreCase(customer.getAddress().getDistrict())
                .isEmpty();
    }
}
