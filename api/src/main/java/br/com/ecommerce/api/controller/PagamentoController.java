package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService Service){
        this.pagamentoService = Service;
    }

    @GetMapping

    public ResponseEntity<List<Pagamento>> listarTodos(){
        List<Pagamento> pagamento = pagamentoService.listarTodos();
        return ResponseEntity.ok(pagamento);
    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(
            @RequestBody Pagamento pagamento
    ){
        // 1 - tentar cadastrar o pagamento
        pagamentoService.pagamentoCliente(pagamento);
        //codigo 201 - created
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    //2. Adicione a seguinte função no ClienteController:
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);

        if(pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("pagamento não encontrado!");
        }

        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPagamento(@PathVariable Integer id) {
        // 1. Verifico se o cliente existe
        Pagamento pagamento = pagamentoService.deletarPagamento(id);

        // 2. Se não existir retorno erro
        if (pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pagamento " + id + " não encontrado!");
        }

        // 3. Se existir, retorno ok
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPagamento(
            @PathVariable Integer id, @RequestBody Pagamento pagamentoNovo) {
        //1 tento atualizar o cliente
        Pagamento pagamento = pagamentoService.atualizarPagamento(id, pagamentoNovo);
        //2 se nao achar o cliente, mostro o erro
        if (pagamento == null) {
            return ResponseEntity.status(404)
                    .body("pagamento nao encontrado");
        }
        // 3 se achar retorno ok
        return ResponseEntity.ok(pagamento);
    }



}
