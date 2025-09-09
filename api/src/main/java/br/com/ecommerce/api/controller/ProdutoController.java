package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService Service) {
        this.produtoService = Service;
    }
    //listar todos
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    };

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(
            @RequestBody Produto produto

    ){  //1 - tentar cadastrar o cliente
        produtoService.cadastrarProduto(produto);
        //codigo 201 - ok
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }
}
