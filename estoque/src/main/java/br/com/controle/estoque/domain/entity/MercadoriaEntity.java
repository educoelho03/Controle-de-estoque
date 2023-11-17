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
    @PastOrPresent
    private LocalDate date;

    @NotBlank
    @Size(max = 100)
    private String name; // Adicionar anotações de validação

    @NotBlank
    @Length(max = 250)
    private String description;

    @NotBlank
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @NotBlank
    @Min(value = 0)
    private Integer amount; //quantidade

    @NotBlank
    @Formula("price * amount")
    private Double total;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private InOutEnum type;

    public MercadoriaEntity(String name, LocalDate date, BigDecimal price, Integer amount, Double total, InOutEnum type, String description){
        this.name = name;
        this.date = date;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.type = type;
        this.description = description;
    }

//    public Mercadoria(MercadoriaDTO mercadoriaDTO){
//        this.name = mercadoriaDTO.getName();
//        this.description = mercadoriaDTO.getDescription();
//        this.amount = mercadoriaDTO.getAmount();
//        this.type = mercadoriaDTO.getType();
//        this.stockPrice = mercadoriaDTO.getStockPrice();
//    }

}
