package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    //injeção de dependencia
    //falar que o service depende de alguem
    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository repository) {
        pedidoRepository = repository;
    }
    //listar todos os clientes
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    //insert into BLABLA
    public Pedido cadastrarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    };
    //buscar por id
    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido deletarPedido(Integer id) {
        //verifico se o pedido existe
        Pedido pedido = buscarPorId(id);

        //2. Se não existir, retorno nulo
        if (pedido == null){
            return null;
        }

        //3 Se existir , excluo
        pedidoRepository.delete(pedido);
        return pedido;
    }

    public Pedido atualizarPedido(Integer id, Pedido pedidoNovo) {
        //1 Procurar quem eu quero atualizar
        Pedido pedidoAntigo = buscarPorId(id);

        //2 Se eu não achar, retorno nulo
        if (pedidoAntigo == null) {
            return null;
        }
        //3 se eu achar eu atualizo
        pedidoAntigo.setStatus(pedidoNovo.getStatus());
        pedidoAntigo.setDataPedido(pedidoNovo.getDataPedido());
        pedidoAntigo.setValorTotal(pedidoNovo.getValorTotal());
        pedidoAntigo.setId(pedidoNovo.getId());

        return pedidoRepository.save(pedidoAntigo);

    }
}
