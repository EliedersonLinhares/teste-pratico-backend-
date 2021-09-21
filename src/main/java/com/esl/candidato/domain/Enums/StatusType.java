package com.esl.candidato.domain.Enums;

public enum StatusType {
    ABERTA(1, "Aberta"),
    FECHADA(2, "Fechada");

    private Integer cod;
    private String description;
    
    private StatusType(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }
    public String getDescription() {
        return description;
    }

    /**
     * Retorna um dos campos enumerados baseado no campo "cod"
     */
    public static StatusType toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        /**
         * Percorre todos os valores  e verifica se o codigo retornado é o mesmo do "x"
         * ,se for retorna o campo enumerado
        **/
         for(StatusType x : StatusType.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Codigo invalido: " + cod);
    }
}
