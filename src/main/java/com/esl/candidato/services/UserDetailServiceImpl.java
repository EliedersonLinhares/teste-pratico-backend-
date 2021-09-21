package com.esl.candidato.services;

import com.esl.candidato.domain.Candidato;
import com.esl.candidato.repositories.CandidatoRepository;
import com.esl.candidato.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private CandidatoRepository repo;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Candidato cand = repo.findByEmail(email);
       if(cand == null){
           throw new UsernameNotFoundException(email);
       }
        return new UserSS(cand.getId(), cand.getEmail(), cand.getSenha(), cand.getRoles());
    }
    
}
