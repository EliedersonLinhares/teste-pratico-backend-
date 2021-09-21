package com.esl.candidato.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.esl.candidato.services.validations.CandidatoInsert;

import org.hibernate.validator.constraints.Length;

@CandidatoInsert
public class CandidatoNewDTO  implements Serializable{
    private static final long serialVersionUID = 1L;


    private Integer id;

 
    @NotNull(message = "Campo nome é obrigatório")
    @Length(min = 5,max = 120, message = "O campo nome deve ter entre 5 e 120 caracteres")
    private String name;

    @NotNull(message = "Campo nome é obrigatório")
    @Email(message = "Email iválido")
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

  
    @NotNull(message = "Campo senha é obrigatório")
    private String senha;
    
   
    public CandidatoNewDTO() {
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
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
