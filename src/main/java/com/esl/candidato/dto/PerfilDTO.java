package com.esl.candidato.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.esl.candidato.domain.Perfil;

import org.hibernate.validator.constraints.Length;


/*
 * DATA TRANSFER OBJECT, objeto que terá somente os dados nescessários para a operação
 * , ou projeção de dados
 */
public class PerfilDTO implements Serializable {
    private Integer id;

 
   @NotNull(message = "Campo resultado é obrigatório")
   @Length(min = 5,max = 120, message = "O campo nome deve ter entre 5 e 120 caracteres")
    private String result;

    public PerfilDTO() {
    }

    public PerfilDTO(Perfil obj) {
        id = obj.getId();
        result = obj.getResult();
      
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

  

 
}
