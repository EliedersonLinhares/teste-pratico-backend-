package com.esl.candidato.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.esl.candidato.domain.Vaga;


/*
 * DATA TRANSFER OBJECT, objeto que terá somente os dados nescessários para a operação
 * , ou projeção de dados
 */
public class VagaDTO implements Serializable {
    private Integer id;

 
   @NotNull(message = "Campo nome é obrigatório")
    private Date date;

    @NotNull(message = "Campo nome é obrigatório")
    private String description;

    private Integer status;
    
    
    
   
    public VagaDTO() {
    }

    public VagaDTO(Vaga obj) {
        id = obj.getId();
        date = obj.getDate();
        description = obj.getDescription();
        status = obj.getStatus().getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    

}
