package com.esl.candidato.services;

import com.esl.candidato.security.UserSS;

import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {
    
    //Retorna o usuário logado
    public static UserSS authenticated(){
        try{
        return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }
}
