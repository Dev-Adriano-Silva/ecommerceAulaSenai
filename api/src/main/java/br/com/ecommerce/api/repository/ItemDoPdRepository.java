package br.com.ecommerce.api.repository;


import br.com.ecommerce.api.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDoPdRepository extends JpaRepository<Pagamento, Integer> {

}
