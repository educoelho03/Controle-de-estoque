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
@Setter
@Getter
public class MercadoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name; // Adicionar anotações de validação

    @PastOrPresent
    private LocalDate date;

    @NotBlank
    @Length(max = 250)
    private String description;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Min(value = 0)
    private Integer amount; //quantidade

    @Formula("price * amount")
    private Double total;

    @Enumerated(EnumType.STRING)
    private InOutEnum type;

    public MercadoriaEntity(String name, LocalDate date, String description, BigDecimal price, Integer amount, Double total, InOutEnum type) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.type = type;
    }

    private MercadoriaEntity(){
    }


    public static class Builder {
        private final MercadoriaEntity mercadoria = new MercadoriaEntity();

        public Builder withName(String name) {
            mercadoria.name = name;
            return this;
        }

        public Builder withDate(LocalDate date) {
            mercadoria.date = date;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            mercadoria.price = price;
            return this;
        }

        public Builder withAmount(int amount) {
            mercadoria.amount = amount;
            return this;
        }

        public Builder withType(InOutEnum type) {
            mercadoria.type = type;
            return this;
        }

        public Builder withDescription(String description) {
            mercadoria.description = description;
            return this;
        }

        public MercadoriaEntity build() {
            mercadoria.total = mercadoria.price.doubleValue() * mercadoria.amount;
            return mercadoria;
        }
    }
}
