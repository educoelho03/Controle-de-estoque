package br.com.controle.estoque.model.dto;

import br.com.controle.estoque.model.InOutEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// TODO: VERIFICAR USO DESTA CLASSE
public class MercadoriaResponseDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    String description;

    @JsonProperty("amount")
    int amount;

    @JsonProperty("price")
    InOutEnum type;
}
