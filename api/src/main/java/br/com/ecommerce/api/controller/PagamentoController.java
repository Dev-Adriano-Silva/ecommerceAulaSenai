package br.com.ecommerce.api.controller;

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


}
