package br.com.controle.estoque.domain.dto;

import br.com.controle.estoque.domain.enums.InOutEnum;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(force = true)
public record MercadoriaDTO(
        @JsonProperty("name")
        String name,// Adicionar anotações de validação

        @JsonProperty("date")
        LocalDate date,

        @JsonProperty("description")
        String description,

        @JsonProperty("price")
        Double price,

        @JsonProperty("amount")
        int amount,//quantidade

        @JsonProperty("total")
        Double total,

        @JsonProperty("type")
        InOutEnum type
        ) {}
