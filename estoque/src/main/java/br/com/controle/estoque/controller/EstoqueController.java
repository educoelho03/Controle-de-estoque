package br.com.controle.estoque.controller;

import br.com.controle.estoque.model.Mercadoria;
import br.com.controle.estoque.service.EstoqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping()
    public ResponseEntity<List<Mercadoria>> getAllMercadorias(){
        return new ResponseEntity<>(estoqueService.findAll(), HttpStatus.ACCEPTED);
    }


}
