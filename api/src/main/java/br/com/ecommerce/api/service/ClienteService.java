package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    //Injeção de dependencia
    //Falar que service depende de alguem
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo) {
        clienteRepository = repo;
    }

    //listar todos os clientes
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    };

    //INSERT INTO BLABLA
    public Cliente cadastrarCliente(Cliente cl){
        return clienteRepository.save(cl);
    };
    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente deletarCliente(Integer id) {
        // 1. Verifico se o Cliente existe
        Cliente cliente = buscarPorId(id);

        // 2. Se não existir, retorno nulo
        if (cliente == null) {
            return null;
        }

        // 3. Se existir, excluo
        clienteRepository.delete(cliente);
        return cliente;
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteNovo) {
        //1 Procurar quem eu quero atualizar
        Cliente clieneAntigo = buscarPorId(id);

        //2 Se eu não achar, retorno nulo
        if (clieneAntigo == null) {
            return null;
        }
        //3 se eu achar eu atualizo
        clieneAntigo.setSenha(clienteNovo.getSenha());
        clieneAntigo.setNomeCompleto(clienteNovo.getNomeCompleto());
        clieneAntigo.setDataCadastro(clienteNovo.getDataCadastro());
        clieneAntigo.setTelefone(clienteNovo.getTelefone());

        return clienteRepository.save(clieneAntigo);

    }


}
