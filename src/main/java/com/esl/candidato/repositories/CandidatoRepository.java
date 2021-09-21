package com.esl.candidato.repositories;



import com.esl.candidato.domain.Candidato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer> {
    
    @Transactional(readOnly = true)
    Candidato findByEmail(String email);

    
}
