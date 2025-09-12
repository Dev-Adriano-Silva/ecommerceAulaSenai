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

    public Pagamento buscarPagamentoPorId(Integer id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public Pagamento deletarPagamento(Integer id) {
        // 1. Verifico se o Cliente existe
        Pagamento pagamento = buscarPagamentoPorId(id);

        // 2. Se não existir, retorno nulo
        if (pagamento == null) {
            return null;
        }

        // 3. Se existir, excluo
        pagamentoRepository.delete(pagamento);
        return pagamento;
    }

    public Pagamento atualizarPagamento(Integer id, Pagamento pagamentoNovo) {
        //1 Procurar quem eu quero atualizar
        Pagamento pagamentoAntigo = buscarPagamentoPorId(id);

        //2 Se eu não achar, retorno nulo
        if (pagamentoAntigo == null) {
            return null;
        }
        //3 se eu achar eu atualizo
        pagamentoAntigo.setDataPagamento(pagamentoNovo.getDataPagamento());
        pagamentoAntigo.setFormaPagamento(pagamentoNovo.getFormaPagamento());
        pagamentoAntigo.setStatus(pagamentoNovo.getStatus());
        pagamentoAntigo.setPedido(pagamentoNovo.getPedido());

        return pagamentoRepository.save(pagamentoAntigo);

    }
}
