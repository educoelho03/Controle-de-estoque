package br.com.controle.estoque.controller;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.entity.FornecedorEntity;
import br.com.controle.estoque.useCases.fornecedorImp.FindAllFornecedorInteractor;
import br.com.controle.estoque.useCases.fornecedorImp.FindFornecedorByIdInteractor;
import br.com.controle.estoque.useCases.fornecedorImp.RegisterFornecedorInteractor;
import br.com.controle.estoque.useCases.mercadoriaImp.FindByIdMercadoriaInteractor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final RegisterFornecedorInteractor registerFornecedor;
    private final FindAllFornecedorInteractor findAllFornecedor;
    private final FindFornecedorByIdInteractor findFornecedorById;


    public FornecedorController(RegisterFornecedorInteractor registerFornecedor, FindAllFornecedorInteractor findAllFornecedor,
                                FindFornecedorByIdInteractor findByIdMercadoria) {
        this.registerFornecedor = registerFornecedor;
        this.findAllFornecedor = findAllFornecedor;
        this.findFornecedorById = findByIdMercadoria;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar", description = "Método que cadastra um fornecedor novo", tags = "Fornecedor")
    public ResponseEntity<FornecedorDTO> registrar(@RequestBody FornecedorEntity fornecedor){
        FornecedorDTO fornecedorDTO = registerFornecedor.registerFornecedor(fornecedor);
        return new ResponseEntity<>(fornecedorDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    @Operation(summary = "Listar", description = "Método que lista todos os fornecedores", tags = "Fornecedor")
    public ResponseEntity<List<FornecedorDTO>> listar(){
        List<FornecedorDTO> listaFornecedor = findAllFornecedor.listar();
        return new ResponseEntity<>(listaFornecedor, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar por ID", description = "Método que busca o fornecedor por ID", tags = "Fornecedor")
    public ResponseEntity<FornecedorDTO> listarPorId(@PathVariable Long id){
        FornecedorDTO listaFornecedorPorId = findFornecedorById.listaPorId(id);
        return new ResponseEntity<>(listaFornecedorPorId, HttpStatus.OK);
    }
}
