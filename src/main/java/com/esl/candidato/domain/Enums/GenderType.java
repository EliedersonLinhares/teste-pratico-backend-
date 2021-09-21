package com.esl.candidato.domain.Enums;

public enum GenderType {
    MULHER(1,"Mulher"),
    HOMEM(2,"Homem"),
    HOMEMTRANSGENERO(3, "Homem Transgênero"),
    MULHERTRANSGENERO(4, "Mulher Transgênero"),
    INTERGENERO(5, "Intergênero"),
    NAOINFORMADO(6, "Não Informado");

    private Integer cod;
    private String description;
    
    private GenderType(Integer cod, String description) {
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
    public static GenderType toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        /**
         * Percorre todos os valores  e verifica se o codigo retornado é o mesmo do "x"
         * ,se for retorna o campo enumerado
        **/
         for(GenderType x : GenderType.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Codigo invalido: " + cod);
    }
    
}
