package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService Service) {
        this.pedidoService = Service;
    }

    //listar todos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedido(){

        List<Pedido> pedidos = pedidoService.listarTodos();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(
            @RequestBody Pedido pedido
    ){
        //1 tentar cadastrar o pedido
        pedidoService.cadastrarPedido(pedido);
        //codigo 201 - CREATED
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }
    //2. Adicione a seguinte função no ClienteController:
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id){
        Pedido pedido = pedidoService.buscarPorId(id);

        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("CLiente nao encontrado");
        }
        return ResponseEntity.ok(pedido);
    }

    //funcao de deletar
    public ResponseEntity<?> deletarPedido(@PathVariable Integer id) {
        // 1. Verifico se o cliente existe
        Pedido pedido = pedidoService.deletarPedido(id);

        // 2. Se não existir retorno erro
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido " + id + " não encontrado!");
        }

        // 3. Se existir, retorno ok
        return ResponseEntity.ok(pedido);
    }

}
