package br.com.controle.estoque.useCases.mercadoriaImp;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.MercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VerificaEstoque {

    private final MercadoriaRepository mercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(VerificaEstoque.class);


    public VerificaEstoque(MercadoriaRepository mercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.mercadoriaRepository = mercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public boolean alertaEstoque(Long id){
        MercadoriaDTO mercadoriaDTO = mercadoriaRepository.findById(id)
                .map(mercadoriaEntityMapper::toDTO)
                .orElseThrow(() -> new NoSuchElementException("Mercadoria não encontrada"));

        MercadoriaEntity mercadoria = mercadoriaEntityMapper.ToEntity(mercadoriaDTO);

        if(mercadoriaDTO.amount() < 10){
            logger.warn("ALERTA!! - Estoque Baixo para a mercadoria com ID: " + id + ". Quantidade atual: " + mercadoria.getAmount());
            logger.info("SOLICITAR REPOSIÇÃO DE ESTOQUE PARA A MERCADORIA " + mercadoria.getName() + ". id: " + id);
            return true;
        }
        logger.info("Estoque atual: " + mercadoria.getAmount() + " unidades.");
        return false;
    }


}
