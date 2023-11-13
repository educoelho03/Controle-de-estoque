package br.com.controle.estoque.controller;

import br.com.controle.estoque.exceptionHandler.RecordNotFoundException;
import br.com.controle.estoque.model.Mercadoria;
import br.com.controle.estoque.model.dto.MercadoriaDTO;
import br.com.controle.estoque.service.EstoqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping()
    public ResponseEntity<List<MercadoriaDTO>> getAllMercadorias(){
        return new ResponseEntity<>(estoqueService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MercadoriaDTO> getMercadoriaById(@PathVariable Long id) throws RecordNotFoundException {
        return new ResponseEntity<>(estoqueService.findMercadoriaById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<MercadoriaDTO> create(Mercadoria mercadoria){
        return new ResponseEntity<>(estoqueService.createMercadoria(mercadoria), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MercadoriaDTO> update(@PathVariable Long id, Mercadoria mercadoria){
        return new ResponseEntity<>(estoqueService.update(id, mercadoria), HttpStatus.ACCEPTED);
    }

}
