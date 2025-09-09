package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class CLienteController {
    private final ClienteService clienteService;

    public CLienteController(ClienteService Service) {
        this.clienteService = Service;
    }

    //Listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        //1. Pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    };

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(
           @RequestBody Cliente cliente
    ){
        //1 - tentar cadastrar o cliente
        clienteService.cadastrarCliente(cliente);
        //codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

    }
}
