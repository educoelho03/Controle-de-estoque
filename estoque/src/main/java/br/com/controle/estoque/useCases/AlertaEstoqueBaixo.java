package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;


public class AlertaEstoqueBaixo {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(AlertaEstoqueBaixo.class);


    public AlertaEstoqueBaixo(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public void alertaEstoque(Long id){
        MercadoriaDTO mercadoriaDTO = estoqueRepository.findById(id)
                .map(mercadoriaEntityMapper::toDTO)
                .orElseThrow(() -> new NoSuchElementException("Mercadoria não encontrada"));

        MercadoriaEntity mercadoria = mercadoriaEntityMapper.ToEntity(mercadoriaDTO);

        if(mercadoriaDTO.amount() < 10){
            logger.warn("ALERTA!! - Estoque Baixo para a mercadoria com ID: " + id + ". Quantidade atual: " + mercadoria.getAmount());
        }
    }


}
