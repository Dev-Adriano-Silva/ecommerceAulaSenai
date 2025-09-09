package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    //Injeção de dependencia
    //Falar que service depende de alguem
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        clienteRepository = repo;
    }

    //listar todos os clientes
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    };

    //INSERT INTO BLABLA
    public Cliente cadastrarCliente(Cliente cl){
        return clienteRepository.save(cl);
    };
}
