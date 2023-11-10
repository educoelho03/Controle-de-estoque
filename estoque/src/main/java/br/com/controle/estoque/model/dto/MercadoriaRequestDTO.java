package br.com.controle.estoque.model.dto;

import br.com.controle.estoque.model.InOutEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// TODO: VERIFICAR USO DESTA CLASSE
public class MercadoriaRequestDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;// Adicionar anotações de validação

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private int amount;//quantidade

    @JsonProperty("type")
    private InOutEnum type;

    @JsonProperty("stockPrice")
    private Double stockPrice;

}
