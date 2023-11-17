package br.com.controle.estoque.gateways;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;

import java.util.List;
import java.util.Optional;

public interface EstoqueGateway {

    MercadoriaEntity registerMercadoria(MercadoriaEntity mercadoria);
    Optional<MercadoriaEntity> findMercadoriaById(Long id);
    List<MercadoriaEntity> findAll();
    MercadoriaEntity update(MercadoriaEntity mercadoria);
    void deleteMercadoriaById(Long id);

}
