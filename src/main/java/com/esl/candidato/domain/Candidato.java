package com.esl.candidato.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.esl.candidato.domain.Enums.GenderType;
import com.esl.candidato.domain.Enums.RoleType;
import com.esl.candidato.domain.Enums.SizeType;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Candidato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @Column(unique = true)
    private String email;

 
    private String phone;
    private String country;
    private String company;
    private String job;
    private Integer gender;
    private Integer size;

    @JsonIgnore
    private String senha;

     @ElementCollection(fetch = FetchType.EAGER)
     @CollectionTable(name="ROLES")
     private Set<Integer> roles = new HashSet<>(); 
     
     @ManyToOne
     @JoinColumn(name="vaga_id")
     private Vaga vaga;

     @ManyToOne
     @JoinColumn(name="perfil_id")
     private Perfil perfil;

    public Candidato(Integer id, String name, String email, String phone, String country, String company,
            GenderType gender, String job, SizeType size, String senha, Perfil perfil,Vaga vaga) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.company = company;
        this.gender = gender.getCod();
        this.job = job;
        this.size = size.getCod();
        this.senha = senha;
        addRole(RoleType.BASIC);
        this.perfil = perfil;
        this.vaga = vaga;
    }

    public Candidato() {
        addRole(RoleType.BASIC);
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

    public GenderType getGender() {
        return GenderType.toEnum(gender);
    }

    public void setGender(GenderType gender) {
        this.gender = gender.getCod();
    }

    public SizeType getSize() {
        return SizeType.toEnum(size);
    }

    public void setSize(SizeType size) {
        this.size = size.getCod();
    }


    
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<RoleType> getRoles(){
		return roles.stream().map(x -> RoleType.toEnum(x)).collect(Collectors.toSet());//retorna os perfis do cliente
	}
	public void addRole(RoleType roleType) {
		roles.add(roleType.getCod());
	}

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Candidato other = (Candidato) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
