package br.com.controle.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
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
    private InOutEnum type;

    @NotBlank
    private Double stockPrice;

}
