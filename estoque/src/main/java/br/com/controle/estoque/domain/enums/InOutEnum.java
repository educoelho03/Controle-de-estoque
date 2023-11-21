package br.com.controle.estoque.domain.enums;

public enum InOutEnum {
    ENTER("E"),
    EXIT("S");

    private final String value;

    InOutEnum(String value){
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
