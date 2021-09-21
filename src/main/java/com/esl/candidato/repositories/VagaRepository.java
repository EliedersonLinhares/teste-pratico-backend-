package com.esl.candidato.repositories;



import com.esl.candidato.domain.Vaga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga,Integer> {

    
}
