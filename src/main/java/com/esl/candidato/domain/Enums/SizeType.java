package com.esl.candidato.domain.Enums;

public enum SizeType {
    PEQUENO(1, "Pequeno"),
    MEDIO(2, "Médio"),
    GRANDE(3, "Grande");

    private Integer cod;
    private String description;
    
    private SizeType(Integer cod, String description) {
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
    public static SizeType toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        /**
         * Percorre todos os valores  e verifica se o codigo retornado é o mesmo do "x"
         * ,se for retorna o campo enumerado
        **/
         for(SizeType x : SizeType.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Codigo invalido: " + cod);
    }
}
