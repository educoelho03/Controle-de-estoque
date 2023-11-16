package br.com.controle.estoque.controller;

import br.com.controle.estoque.exceptionHandler.RecordNotFoundException;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.useCases.DeleteByIdMercadoriaInteractor;
import br.com.controle.estoque.useCases.FindAllMercadoriaInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class MercadoriaController {

    // TODO: AO USAR O USE CASE, EU VOU TER VARIOS CONSTRUTORES ASSIM MESMO? OU PRECISO CRIAR VARIOS CONTROLLERS, CADA UM EXECUTANDO UMA COISA?
    private final FindAllMercadoriaInteractor findAllMercadoriaInteractor;
    private final DeleteByIdMercadoriaInteractor deleteByIdMercadoriaInteractor;

    public MercadoriaController(FindAllMercadoriaInteractor findAllMercadoriaInteractor,
                                DeleteByIdMercadoriaInteractor deleteByIdMercadoriaInteractor) {

        this.findAllMercadoriaInteractor = findAllMercadoriaInteractor;
        this.deleteByIdMercadoriaInteractor = deleteByIdMercadoriaInteractor;
    }

    // TODO: IMPLEMENTAR TODAS OS USECASES CERTINHO
    @GetMapping("/mercadorias")
    public ResponseEntity<List<MercadoriaDTO>> getAllMercadorias(){
        return new ResponseEntity<>(findAllMercadoriaInteractor.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MercadoriaDTO> getMercadoriaById(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity<>(estoqueService.findMercadoriaById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/mercadorias/registrar")
    public ResponseEntity<MercadoriaDTO> create(MercadoriaEntity mercadoriaEntity){
        return new ResponseEntity<>(registerMercadoria.registerMercadoria(mercadoriaEntity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MercadoriaDTO> update(@PathVariable Long id, MercadoriaEntity mercadoriaEntity){
        return new ResponseEntity<>(estoqueService.update(id, mercadoriaEntity), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercadoriaById(@PathVariable Long id){
        boolean deleted = deleteByIdMercadoriaInteractor.deleteMercadoriaById(id);
        if (deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
