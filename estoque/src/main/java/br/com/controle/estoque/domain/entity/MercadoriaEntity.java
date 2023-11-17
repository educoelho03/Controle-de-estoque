package br.com.controle.estoque.domain.entity;

import br.com.controle.estoque.domain.enums.InOutEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "mercadorias")
@Table(name = "tb_mercadoria")
@Getter
@Setter
public class MercadoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private LocalDate date;

    @NotBlank
    private String name; // Adicionar anotações de validação

    @NotBlank
    private String description;

    @NotBlank
    @DecimalMin(value = "0.0", inclusive = false)
    private Double price;

    @NotBlank
    @Min(value = 0)
    private Integer amount; //quantidade

    @NotBlank
    @Formula("price * amount")
    private Double total = price * amount;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private InOutEnum type;

    public MercadoriaEntity(String name, LocalDate date, Double price, Integer amount, Double total, InOutEnum type, String description){
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
