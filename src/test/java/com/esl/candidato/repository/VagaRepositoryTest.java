package com.esl.candidato.repository;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.esl.candidato.domain.Vaga;
import com.esl.candidato.domain.Enums.StatusType;
import com.esl.candidato.repositories.VagaRepository;

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
public class VagaRepositoryTest {

    
    @Autowired
    private VagaRepository repo2;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void CadastrarVagaComSucesso() throws ParseException{
      
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

         Vaga vaga = new Vaga();
         vaga.setDate(sdf.parse("30/09/2017 10:32"));
         vaga.setDescription("Desenvolvimento de software em python");
         vaga.setStatus(StatusType.toEnum(1));

         repo2.save(vaga);

       
         Assertions.assertThat(vaga.getId()).isGreaterThan(0);
    }
    
  
    @Test
    @Order(2)
    public void EncontrarCandidaPorId(){
       Vaga id = repo2.findById(1).get();
        Assertions.assertThat(id.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    public void EncontrarTodosCandidatos(){
        List<Vaga> vagas = repo2.findAll();
        Assertions.assertThat(vagas.size()).isGreaterThan(0);
 
    }
    @Test
    @Order(4)
    @Rollback(value = false)
    public void AtualizarVaga(){
        Vaga vaga = repo2.findById(1).get();
        
        vaga.setDescription("Desenvolvimento de software em python e banco de dados MongoDB");

        Vaga vagaUpdated = repo2.save(vaga);

        Assertions.assertThat(vagaUpdated.getDescription().equalsIgnoreCase("Desenvolvimento de software em python e banco de dados MongoDB"));
 
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void DeletarVaga(){
        Vaga vaga = repo2.findById(1).get();
    
        repo2.delete(vaga);

        Assertions.assertThat(repo2.count()).isZero();
 
    }

}
