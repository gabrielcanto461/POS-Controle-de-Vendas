package br.com.posprodutos.usecases.client;

import br.com.posprodutos.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FindCustomerUseCases {

    List<CustomerDTO> findAllClients();
    List<CustomerDTO> findByDistrict(String district);
    List<CustomerDTO> findByName(String name);
    List<CustomerDTO> findByNameAndDistrict(String name, String district);
    CustomerDTO findById(Long id);

}
