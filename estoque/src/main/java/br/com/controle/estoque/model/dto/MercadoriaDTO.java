package br.com.controle.estoque.model.dto;

import br.com.controle.estoque.model.enums.InOutEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(force = true)
public record MercadoriaDTO(
        @JsonProperty("name")
        String name,// Adicionar anotações de validação

        @JsonProperty("description")
        String description,

        @JsonProperty("amount")
        int amount,//quantidade

        @JsonProperty("type")
        InOutEnum type,

        @JsonProperty("stockPrice")
        Double stockPrice
        ) {}
