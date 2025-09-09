package br.com.ecommerce.api.service;

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

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }
}
