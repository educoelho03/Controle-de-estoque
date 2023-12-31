package br.com.controle.estoque.domain.dto;

import br.com.controle.estoque.domain.enums.Estados;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO(
        @JsonProperty("name")
        @NotBlank(message = "Name is required")
        String name,

        @JsonProperty("estados")
        @NotBlank(message = "state is required")
        Estados estados,

        @JsonProperty("cnpj")
        @NotBlank(message = "cnpj is required")
        String cnpj,

        @NotBlank(message = "telefone is required")
        @JsonProperty("telefone")
        String telefone) {

}
