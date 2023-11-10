package br.com.controle.estoque.repository;

import br.com.controle.estoque.model.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Mercadoria, Long> {
}
