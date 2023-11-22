package br.com.controle.estoque.domain.entity;

import br.com.controle.estoque.domain.enums.InOutEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "mercadorias")
@Table(name = "tb_estoque")
@Getter
@Setter
public class MercadoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name; // Adicionar anotações de validação

    @NotBlank
    @PastOrPresent
    private LocalDate date;

    @NotBlank
    @Length(max = 250)
    private String description;

    @NotBlank
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotBlank
    @Min(value = 0)
    private Integer amount; //quantidade

    @Formula("price * amount")
    private Double total;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private InOutEnum type;

    private MercadoriaEntity(){
    }



    public static class Builder {
        private final MercadoriaEntity mercadoria = new MercadoriaEntity();

        public Builder name(String name) {
            mercadoria.name = name;
            return this;
        }

        public Builder date(LocalDate date) {
            mercadoria.date = date;
            return this;
        }

        public Builder price(BigDecimal price) {
            mercadoria.price = price;
            return this;
        }

        public Builder amount(int amount) {
            mercadoria.amount = amount;
            return this;
        }

        public Builder total(Double total) {
            mercadoria.total = total;
            return this;
        }

        public Builder type(InOutEnum type) {
            mercadoria.type = type;
            return this;
        }

        public Builder description(String description) {
            mercadoria.description = description;
            return this;
        }

        public MercadoriaEntity build() {
            return mercadoria;
        }
    }
}
