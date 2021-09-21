package com.esl.candidato.services;

import java.util.Optional;

import com.esl.candidato.domain.Perfil;
import com.esl.candidato.dto.PerfilDTO;
import com.esl.candidato.repositories.PerfilRepository;
import com.esl.candidato.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class PerfilServices {


   @Autowired
   private PerfilRepository repo;

   

    public Perfil find(Integer id) {

        Optional<Perfil> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
    }


    public Perfil insert(Perfil obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Perfil update(Perfil obj) {
        Perfil newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public Perfil fromDTO(PerfilDTO objDto) {
        return new Perfil(objDto.getId(), objDto.getResult(),null);
    }
    private void updateData(Perfil newObj, Perfil obj) {
        newObj.setResult(obj.getResult());
       
    }
}
