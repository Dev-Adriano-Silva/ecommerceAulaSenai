package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    //injecao de dependencia
    //falar que o service depende de alguem
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository repository){
        pagamentoRepository =  repository;
    }
    public List<Pagamento> listarTodos(){
        return pagamentoRepository.findAll();
    }

    //INSERT INTO BLABLA
    public Pagamento pagamentoCliente(Pagamento pg){
        return pagamentoRepository.save(pg);
    }
}
