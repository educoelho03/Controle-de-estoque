package br.com.controle.estoque.repository;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// todo: implementar a rota de gateway
public interface EstoqueMercadoriaRepository extends JpaRepository<MercadoriaEntity, Long> {
}
