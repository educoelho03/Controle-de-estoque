package br.com.controle.estoque.useCases.mercadoriaImp;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.MercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FindByIdMercadoriaInteractor {

    private final MercadoriaRepository mercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private final VerificaEstoque verificaEstoque;
    private static final Logger logger = LoggerFactory.getLogger(FindByIdMercadoriaInteractor.class);


    public FindByIdMercadoriaInteractor(MercadoriaRepository mercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper, VerificaEstoque verificaEstoque) {
        this.mercadoriaRepository = mercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
        this.verificaEstoque = verificaEstoque;
    }


    public MercadoriaDTO findMercadoriaById(Long id){
        logger.info("Mercadoria com id " + id + " encontrada com sucesso.");
        verificaEstoque.alertaEstoque(id);
        return mercadoriaRepository.findById(id).map(mercadoriaEntityMapper::toDTO)
                    .orElseThrow( () -> new RecordNotFoundException("Record nao encontrado. " + id));
    }
}
