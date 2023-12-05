package br.com.controle.estoque.controller;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.entity.FornecedorEntity;
import br.com.controle.estoque.useCases.RegisterFornecedorInteractor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final RegisterFornecedorInteractor registerFornecedor;


    public FornecedorController(RegisterFornecedorInteractor registerFornecedor) {
        this.registerFornecedor = registerFornecedor;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar", description = "Método que cadastra um fornecedor novo", tags = "Fornecedor")
    public ResponseEntity<FornecedorDTO> registrar(@RequestBody FornecedorEntity fornecedor){
        FornecedorDTO fornecedorDTO = registerFornecedor.registerFornecedor(fornecedor);
        return new ResponseEntity<>(fornecedorDTO, HttpStatus.OK);
    }
}
