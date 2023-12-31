package br.com.controle.estoque.domain.dto;

import br.com.controle.estoque.domain.enums.InOutEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MercadoriaDTO(
        @JsonProperty("name")
        @NotBlank(message = "Name is required")
        String name,

        @JsonProperty("date")
        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull(message = "Date is required")
        @PastOrPresent
        LocalDate date,

        @JsonProperty("description")
        @NotBlank(message = "Description is required")
        String description,

        @JsonProperty("price")
        @NotNull
        @DecimalMin(value = "0.0", message = "Price must be greater than 0.0")
        BigDecimal price,

        @JsonProperty("amount")
        @NotNull
        @Min(value = 0, message = "Amount must be greater than or equal to 0")
        Integer amount,

        @NotNull
        @JsonProperty("total")
        Double total,

        @JsonProperty("type")
        @NotNull
        InOutEnum type
        ) {}
