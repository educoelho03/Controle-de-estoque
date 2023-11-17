package br.com.controle.estoque.domain.dto;

import br.com.controle.estoque.domain.enums.InOutEnum;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(force = true)
public record MercadoriaDTO(
        @JsonProperty("name")
        @NotBlank(message = "Name is required")
        String name,// Adicionar anotações de validação

        @JsonProperty("date")
        @NotNull(message = "Date is required")
        @PastOrPresent
        LocalDate date,

        @JsonProperty("description")
        @NotBlank(message = "Description is required")
        String description,

        @JsonProperty("price")
        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.0", message = "Price must be greater than 0.0")
        BigDecimal price,

        @JsonProperty("amount")
        @Min(value = 0, message = "Amount must be greater than or equal to 0")
        int amount,//quantidade

        @JsonProperty("total")
        Double total,

        @JsonProperty("type")
        InOutEnum type
        ) {}
