package com.esl.candidato.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.esl.candidato.domain.Candidato;
import com.esl.candidato.services.validations.CandidatoUpdate;

import org.hibernate.validator.constraints.Length;


/*
 * DATA TRANSFER OBJECT, objeto que terá somente os dados nescessários para a operação
 * , ou projeção de dados
 */
@CandidatoUpdate
public class CandidatoDTO implements Serializable {
    private Integer id;

 
   @NotNull(message = "Campo nome é obrigatório")
   @Length(min = 5,max = 120, message = "O campo nome deve ter entre 5 e 120 caracteres")
    private String name;

    @NotNull(message = "Campo nome é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "Campo telefone é obrigatório")
    private String phone;

    @NotNull(message = "Campo país é obrigatório")
    private String country;

    @NotNull(message = "Campo empresa é obrigatório")
    private String company;

    @NotNull(message = "Campo ocupação é obrigatório")
    private String job;
    
    private Integer gender;
    
    private Integer size;
    
   
    public CandidatoDTO() {
    }

    public CandidatoDTO(Candidato obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        phone = obj.getPhone();
        country = obj.getCountry();
        company = obj.getCompany();
        gender = obj.getGender().getCod();
        job = obj.getJob();
        size = obj.getSize().getCod();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
