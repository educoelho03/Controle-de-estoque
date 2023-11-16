package br.com.controle.estoque.domain.entity;

import br.com.controle.estoque.domain.enums.InOutEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "mercadorias")
@Table(name = "tb_mercadoria")
@Getter
@Setter
public class Mercadoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name; // Adicionar anotações de validação

    @NotBlank
    private String description;

    @NotBlank
    private Integer amount; //quantidade

    @NotBlank
    @Enumerated(EnumType.STRING)
    private InOutEnum inOut;

    @NotBlank
    private Double stockPrice;


    public Mercadoria(String name, String description, Integer amount, InOutEnum inOut, Double stockPrice){
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.inOut = inOut;
        this.stockPrice = stockPrice;
    }

}
