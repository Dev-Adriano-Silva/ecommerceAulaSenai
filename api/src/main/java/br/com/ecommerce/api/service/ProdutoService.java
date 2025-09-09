package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Produto;
import br.com.ecommerce.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    //injecao de dependencia
    //falar que service depende de alguem
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository prodRepo) {
        this.produtoRepository = prodRepo;

    }
    //    listar todos os produtos
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    };
    //INSERT INTO BLABLA
    public Produto cadastrarProduto(Produto pd){
        return produtoRepository.save(pd);
    }


}
