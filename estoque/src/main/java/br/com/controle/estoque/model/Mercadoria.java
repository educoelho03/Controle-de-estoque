package br.com.controle.estoque.model;

import jakarta.persistence.*;
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
    private String name; // Adicionar anotações de validação
    private String description;
    private int amount; //quantidade
    private InOutEnum type;
    private Double stockPrice;

}
