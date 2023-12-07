package br.com.controle.estoque.domain.entity;

import br.com.controle.estoque.domain.enums.Estados;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "fornecedor")
@Table(name = "tb_fornecedor")
@Setter
@Getter
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Estados sede;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String telefone;

    public FornecedorEntity(String name, Estados sede, String cnpj, String telefone) {
        this.name = name;
        this.sede = sede;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    private FornecedorEntity(){
    }

    public static class Builder {
        private final FornecedorEntity fornecedor = new FornecedorEntity();

        public FornecedorEntity.Builder withName(String name) {
            fornecedor.name = name;
            return this;
        }

        public FornecedorEntity.Builder withSede(Estados sede) {
            fornecedor.sede = sede;
            return this;
        }

        public FornecedorEntity.Builder withCnpj(String cnpj) {
            fornecedor.cnpj = cnpj;
            return this;
        }

        public FornecedorEntity.Builder withtelefone(String telefone) {
            fornecedor.telefone = telefone;
            return this;
        }

        public FornecedorEntity build() {
            return fornecedor;
        }
    }

}
