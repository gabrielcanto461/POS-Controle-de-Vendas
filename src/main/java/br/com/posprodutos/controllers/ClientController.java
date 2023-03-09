package br.com.posprodutos.controllers;

import br.com.posprodutos.dto.CustomerDTO;
import br.com.posprodutos.model.Customer;
import br.com.posprodutos.usecases.client.FindCustomerUseCases;
import br.com.posprodutos.usecases.client.RegisterClientUseCases;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("api/clientes")
public class ClientController {

    FindCustomerUseCases findClientsUseCases;
    RegisterClientUseCases registerClientUseCases;

    @Autowired
    public ClientController(FindCustomerUseCases findCustomerUseCases, RegisterClientUseCases registerClientUseCases) {
        this.findClientsUseCases = findCustomerUseCases;
        this.registerClientUseCases = registerClientUseCases;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> findAllClients() {

        return ResponseEntity.ok().body(findClientsUseCases.findAllClients());
    }

    @GetMapping
    public ResponseEntity<Object> findClient(@RequestParam(required = false, name = "bairro") String district, @RequestParam(required = false, name = "nome") String name) {

        List<CustomerDTO> client = null;

        if(Objects.nonNull(district) && Objects.nonNull(name)){
            log.info("Searching for client by district {} and name {}", district, name);

            client = findClientsUseCases.findByNameAndDistrict(name, district);
        }else if(Objects.nonNull(district)){
            client = findClientsUseCases.findByDistrict(district);
        }else{
            client = findClientsUseCases.findByName(name);
        }

        if (client.isEmpty())
            return ResponseEntity.badRequest().body(String.format("Nenhum cliente com nome = %s e bairro = %s encontrado", name, district));
        return ResponseEntity.ok().body(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        var client = findClientsUseCases.findById(id);

        if (Objects.isNull(client)){
            return ResponseEntity.badRequest().body(String.format("Nenhum cliente com id = %d encontrado", id));
        }
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> registerClient(@RequestBody Customer customer){

        var clientSaved = registerClientUseCases.registerClient(customer);

        if (clientSaved==null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.created(null).body(clientSaved);
    }


}
