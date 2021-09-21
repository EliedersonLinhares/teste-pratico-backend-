package com.esl.candidato.repository;



import com.esl.candidato.domain.Candidato;
import com.esl.candidato.domain.Enums.GenderType;
import com.esl.candidato.domain.Enums.SizeType;
import com.esl.candidato.repositories.CandidatoRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CandidatoRepositoryTest {
    

  
    @Autowired
    private CandidatoRepository repo;
   

    @Test
    @Order(1)
    @Rollback(value = false)
    public void CandidatoCadastradoComSucesso(){
      
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

       
         Assertions.assertThat(candidato.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void EncontarCandidatoPorEmail(){
        //dado...
        String email = "eduardo@mail.com";
         boolean expected = repo.findByEmail(email).getEmail().equalsIgnoreCase("eduardo@mail.com");

         //Então...
         Assertions.assertThat(expected).isTrue();
    }

    @Test
    @Order(3)
    public void EncontrarCandidaPorId(){
       Candidato id = repo.findById(1).get();
        Assertions.assertThat(id.getId()).isEqualTo(1);

    }

    @Test
    @Order(4)
    public void EncontrarTodosCandidatos(){
        List<Candidato> candidatos = repo.findAll();
        Assertions.assertThat(candidatos.size()).isGreaterThan(0);
 
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void AtualizarCandidato(){
        Candidato candidato = repo.findByEmail("eduardo@mail.com");
        
        candidato.setEmail("eduardoBarros@mail.com");

        Candidato candidatoUpdated = repo.save(candidato);

        Assertions.assertThat(candidatoUpdated.getEmail().equalsIgnoreCase("eduardoBarros@mail.com"));
 
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void DeletarCandidato(){
        Candidato candidato = repo.findById(1).get();
    
        repo.delete(candidato);

        Assertions.assertThat(repo.count()).isZero();
 
    }

}
