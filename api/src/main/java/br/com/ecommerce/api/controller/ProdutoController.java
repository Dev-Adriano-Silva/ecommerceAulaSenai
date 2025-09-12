package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
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

    //2. Adicione a seguinte função no ProdutoController:
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable Integer id) {
        Produto produto = produtoService.buscarPorId(id);

        if(produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("produto não encontrado!");
        }

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Integer id) {
        // 1. Verifico se o produto existe
        Produto produto = produtoService.deletarProduto(id);

        // 2. Se não existir retorno erro
        if (produto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("produto " + id + " não encontrado!");
        }

        // 3. Se existir, retorno ok
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(
            @PathVariable Integer id, @RequestBody Produto produtoNovo) {
        //1 tento atualizar o cliente
        Produto produto = produtoService.atualizarProduto(id, produtoNovo);
        //2 se nao achar o cliente, mostro o erro
        if (produto == null) {
            return ResponseEntity.status(404)
                    .body("produto nao encontrado");
        }
        // 3 se achar retorno ok
        return ResponseEntity.ok(produto);
    }
}
