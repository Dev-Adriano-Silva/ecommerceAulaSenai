package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Metodos de clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService Service) {
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

    //2. Adicione a seguinte função no ClienteController:
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarPorId(id);

        if(cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente não encontrado!");
        }

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
        // 1. Verifico se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);

        // 2. Se não existir retorno erro
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente " + id + " não encontrado!");
        }

        // 3. Se existir, retorno ok
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        //1 tento atualizar o cliente
        Cliente cliente = clienteService.atualizarCliente(id, clienteNovo);
        //2 se nao achar o cliente, mostro o erro
        if (cliente == null) {
            return ResponseEntity.status(404)
                    .body("cliente nao encontrado");
        }
        // 3 se achar retorno ok
        return ResponseEntity.ok(cliente);
    }


}
