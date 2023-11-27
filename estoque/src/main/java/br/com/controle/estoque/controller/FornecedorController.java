package br.com.controle.estoque.controller;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.entity.FornecedorEntity;
import br.com.controle.estoque.useCases.RegisterFornecedorInteractor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final RegisterFornecedorInteractor registerFornecedor;


    public FornecedorController(RegisterFornecedorInteractor registerFornecedor) {
        this.registerFornecedor = registerFornecedor;
    }

    @PutMapping("/cadastrar")
    public ResponseEntity<FornecedorDTO> registrar(@RequestBody FornecedorEntity fornecedor){
        FornecedorDTO fornecedorDTO = registerFornecedor.registerFornecedor(fornecedor);
        return new ResponseEntity<>(fornecedorDTO, HttpStatus.OK);
    }
}
