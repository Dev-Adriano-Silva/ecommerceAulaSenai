package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pedido;
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
    public Produto buscarPorId(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto deletarProduto(Integer id){
        //1 verifico se o produto existe
        Produto produto = buscarPorId(id);

        //2 se nao existir retorno nulo
        if (produto == null){
            return null;
        }
        //3 se existir excluo
        produtoRepository.delete(produto);
        return produto;
    }

    public Produto atualizarProduto(Integer id, Produto produtoNovo) {
        //1 Procurar quem eu quero atualizar
        Produto produtoAntigo = buscarPorId(id);

        //2 Se eu não achar, retorno nulo
        if (produtoAntigo == null) {
            return null;
        }
        //3 se eu achar eu atualizo
        produtoAntigo.setDescricao(produtoNovo.getDescricao());
        produtoAntigo.setNomeProduto(produtoNovo.getNomeProduto());
        produtoAntigo.setPreco(produtoNovo.getPreco());
        produtoAntigo.setImagemUrl(produtoNovo.getImagemUrl());

        return produtoRepository.save(produtoAntigo);

    }

}

