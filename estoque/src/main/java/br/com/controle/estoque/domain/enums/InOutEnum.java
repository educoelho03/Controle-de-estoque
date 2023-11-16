package br.com.controle.estoque.domain.enums;

public enum InOutEnum {
    ENTER("Entrada"),
    EXIT("Saida");

    private final String value;

    private InOutEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
