package com.esl.candidato.services;

import java.util.List;
import java.util.Optional;

import com.esl.candidato.domain.Candidato;
import com.esl.candidato.domain.Enums.GenderType;
import com.esl.candidato.domain.Enums.RoleType;
import com.esl.candidato.domain.Enums.SizeType;
import com.esl.candidato.dto.CandidatoDTO;
import com.esl.candidato.dto.CandidatoNewDTO;
import com.esl.candidato.repositories.CandidatoRepository;
import com.esl.candidato.security.UserSS;
import com.esl.candidato.services.exceptions.AuthorizationException;
import com.esl.candidato.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CandidatoServices {

    @Autowired
    private BCryptPasswordEncoder pe;

   @Autowired
   private CandidatoRepository repo;

   

    public Candidato find(Integer id) {

        // para o candidato só retornar ele mesmo
        UserSS user = UserService.authenticated();
        if (user == null || !user.hasRole(RoleType.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Acesso negado");
        }

        Optional<Candidato> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName()));
    }

    public List<Candidato> findAll() {
        return repo.findAll();
    }

    public Candidato insert(Candidato obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Candidato update(Candidato obj) {
        Candidato newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    // busca paginada
    public Page<Candidato> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Candidato fromDTO(CandidatoDTO objDto) {
        return new Candidato(objDto.getId(), objDto.getName(), objDto.getEmail(), objDto.getPhone(),
                objDto.getCompany(), objDto.getCountry(), GenderType.toEnum(objDto.getGender()), objDto.getJob(),
                SizeType.toEnum(objDto.getSize()), null,null,null);
    }

    // Metodo sobrecarregado do FromDTO a partir do ClienteNewDTO
    public Candidato fromDTO(CandidatoNewDTO objDto) {
        Candidato cand = new Candidato(null, objDto.getName(), objDto.getEmail(), objDto.getPhone(),
                objDto.getCompany(), objDto.getCountry(), GenderType.toEnum(objDto.getGender()), objDto.getJob(),
                SizeType.toEnum(objDto.getSize()), pe.encode(objDto.getSenha()),null,null );
        return cand;
    }

    private void updateData(Candidato newObj, Candidato obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setPhone(obj.getPhone());
        newObj.setCompany(obj.getCompany());
        newObj.setCountry(obj.getCountry());
        newObj.setGender(obj.getGender());
        newObj.setEmail(obj.getEmail());
        newObj.setJob(obj.getJob());
        newObj.setSize(obj.getSize());
    }
}
