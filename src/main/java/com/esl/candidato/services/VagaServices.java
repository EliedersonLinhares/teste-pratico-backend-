package com.esl.candidato.services;

import java.util.List;
import java.util.Optional;

import com.esl.candidato.domain.Perfil;
import com.esl.candidato.domain.Vaga;
import com.esl.candidato.domain.Enums.StatusType;
import com.esl.candidato.dto.VagaDTO;
import com.esl.candidato.repositories.VagaRepository;
import com.esl.candidato.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;




@Service
public class VagaServices {


   @Autowired
   private VagaRepository repo;

   

    public Vaga find(Integer id) {

        Optional<Vaga> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
    }

    public List<Vaga> findAll() {
        return repo.findAll();
    }

    public Vaga insert(Vaga obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Vaga update(Vaga obj) {
        Vaga newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    // busca paginada
    public Page<Vaga> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Vaga fromDTO(VagaDTO objDto) {
        return new Vaga(objDto.getId(), objDto.getDate(), objDto.getDescription(), StatusType.toEnum(objDto.getStatus()), null);
    }
    private void updateData(Vaga newObj, Vaga obj) {
        newObj.setDate(obj.getDate());
        newObj.setDescription(obj.getDescription());
        newObj.setStatus(obj.getStatus());

       
    }
}
