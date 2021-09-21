package com.esl.candidato.domain.Enums;

public enum RoleType {
    ADMIN(1, "ROLE_ADMIN"),
    BASIC(2, "ROLE_BASIC");

    private Integer cod;
    private String description;
    
    private RoleType(Integer cod, String description) {
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
    public static RoleType toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        /**
         * Percorre todos os valores  e verifica se o codigo retornado é o mesmo do "x"
         * ,se for retorna o campo enumerado
        **/
         for(RoleType x : RoleType.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Codigo invalido: " + cod);
    }
}
