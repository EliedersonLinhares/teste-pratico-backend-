package com.esl.candidato.repository;



import com.esl.candidato.domain.Candidato;
import com.esl.candidato.domain.Perfil;
import com.esl.candidato.domain.Enums.GenderType;
import com.esl.candidato.domain.Enums.SizeType;
import com.esl.candidato.repositories.CandidatoRepository;
import com.esl.candidato.repositories.PerfilRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PerfilRepositoryTest {
    

  
    @Autowired
    private CandidatoRepository repo;
   
    
    @Autowired
    private PerfilRepository repo2;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void PerfilAtribuidoComSucesso(){
      
        String email = "eduardo@mail.com";
        Candidato candidato = new Candidato();
         candidato.setName("Eduardo");
         candidato.setEmail(email);
         candidato.setPhone("02198892568");
         candidato.setCompany("Microsoft");
         candidato.setCountry("Brasil");
         candidato.setJob("Desenvolvedor Pl/sql");
         candidato.setGender(GenderType.HOMEM);
         candidato.setSize(SizeType.GRANDE);
         candidato.setSenha("123456");
       
     
         repo.save(candidato);

         Perfil perfil = new Perfil();
         perfil.setResult("Candidato com boa dinâmica");
         perfil.setCandidato(candidato);

         repo2.save(perfil);

       
         Assertions.assertThat(perfil.getId()).isGreaterThan(0);
    }
    
  

    @Test
    @Order(2)
    @Rollback(value = false)
    public void AtualizarPerfil(){
        Perfil perfil = repo2.findById(1).get();
        
        perfil.setResult("Candidato com boa dinâmica e dicção");

        Perfil perfilUpdated = repo2.save(perfil);

        Assertions.assertThat(perfilUpdated.getResult().equalsIgnoreCase("Candidato com boa dinâmica e dicção"));
 
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void DeletarPerfil(){
        Perfil perfil = repo2.findById(1).get();
    
        repo2.delete(perfil);

        Assertions.assertThat(repo2.count()).isZero();
 
    }

}
