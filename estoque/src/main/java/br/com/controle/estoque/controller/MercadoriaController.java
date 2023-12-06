package br.com.controle.estoque.controller;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.useCases.mercadoriaImp.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class MercadoriaController {

    // TODO: AO USAR O USE CASE, EU VOU TER VARIOS CONSTRUTORES ASSIM MESMO? OU PRECISO CRIAR VARIOS CONTROLLERS, CADA UM EXECUTANDO UMA COISA?
    private final DeleteByIdMercadoriaInteractor deleteByIdMercadoria;
    private final FindAllMercadoriaInteractor findAllMercadoria;
    private final FindByIdMercadoriaInteractor findByIdMercadoria;
    private final RegisterMercadoriaInteractor registrarMercadoria;
    private final UpdateMercadoriaInteractor updateMercadoria;
    private final AlertaEstoqueBaixo alertaEstoqueBaixo;

    public MercadoriaController(DeleteByIdMercadoriaInteractor deleteByIdMercadoria, FindAllMercadoriaInteractor findAllMercadoria,
                                FindByIdMercadoriaInteractor findByIdMercadoria, RegisterMercadoriaInteractor registrarMercadoria,
                                UpdateMercadoriaInteractor updateMercadoria, AlertaEstoqueBaixo alertaEstoqueBaixo) {
        this.deleteByIdMercadoria = deleteByIdMercadoria;
        this.findAllMercadoria = findAllMercadoria;
        this.findByIdMercadoria = findByIdMercadoria;
        this.registrarMercadoria = registrarMercadoria;
        this.updateMercadoria = updateMercadoria;
        this.alertaEstoqueBaixo = alertaEstoqueBaixo;
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Atualizar", description = "Método que atualiza todas as mercadorias com um ID", tags = "Mercadoria")
    public MercadoriaDTO atualizar(@PathVariable @Valid Long id, @RequestBody MercadoriaEntity mercadoria){
        MercadoriaDTO mercadoriaDTO = updateMercadoria.update(id, mercadoria);
        return new ResponseEntity<>(mercadoriaDTO, HttpStatus.OK).getBody();
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar", description = "Método que atualiza todas as mercadorias com um ID", tags = "Mercadoria")
    public ResponseEntity<MercadoriaDTO> registrar(@RequestBody MercadoriaEntity mercadoria){
        MercadoriaDTO mercadoriaDTO = registrarMercadoria.registerMercadoria(mercadoria);
        return new ResponseEntity<>(mercadoriaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Método que atualiza todas as mercadorias com um ID", tags = "Mercadoria")
    public ResponseEntity<MercadoriaDTO> findById(@PathVariable @Valid Long id){
        MercadoriaDTO mercadoriaDTO = findByIdMercadoria.findMercadoriaById(id);
        return new ResponseEntity<>(mercadoriaDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    @Operation(summary = "Listar", description = "Método que atualiza todas as mercadorias com um ID", tags = "Mercadoria")
    public ResponseEntity<List<MercadoriaDTO>> findAll(){
        List<MercadoriaDTO> mercadoriaDTO = findAllMercadoria.findAll();
        return new ResponseEntity<>(mercadoriaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletar", description = "Método que atualiza todas as mercadorias com um ID", tags = "Mercadoria")
    public ResponseEntity<Boolean> deleteMercadoriaById(@PathVariable @Valid Long id){
        boolean deleted = deleteByIdMercadoria.deleteMercadoriaById(id);

        HttpStatus status = deleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(deleted);
    }

    @GetMapping("/verificaEstoque/{id}")
    @Operation(summary = "Verifica Estoque", description = "Método que atualiza todas as mercadorias com um ID", tags = "Mercadoria")
    public ResponseEntity<Boolean> verificarAlertarEstoque(@PathVariable @Valid Long id) {
        boolean mercadoriaExiste = alertaEstoqueBaixo.alertaEstoque(id);

        HttpStatus status = mercadoriaExiste ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(mercadoriaExiste);
    }
}