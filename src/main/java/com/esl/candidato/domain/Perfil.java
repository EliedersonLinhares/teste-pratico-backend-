package com.esl.candidato.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    
        private String result;
    
        @ManyToOne
        @JoinColumn(name="candidato_id")
        private Candidato candidato;

        

        public Perfil() {
        }



        public Perfil(Integer id, String result, Candidato candidato) {
            this.id = id;
            this.result = result;
            this.candidato = candidato;
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



        public Candidato getCandidato() {
            return candidato;
        }



        public void setCandidato(Candidato candidato) {
            this.candidato = candidato;
        }



       
        
}
