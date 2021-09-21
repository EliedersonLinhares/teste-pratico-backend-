package com.esl.candidato.services.validations;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.esl.candidato.Resource.exceptions.FieldMessage;
import com.esl.candidato.domain.Candidato;
import com.esl.candidato.dto.CandidatoNewDTO;
import com.esl.candidato.repositories.CandidatoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CandidatoInsertValidator implements ConstraintValidator<CandidatoInsert, CandidatoNewDTO> {
   
   @Autowired
   private CandidatoRepository repo; 
   
    @Override
    public void initialize(CandidatoInsert ann) {
    }

    @Override
    public boolean isValid(CandidatoNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
       

      Candidato aux = repo.findByEmail(objDto.getEmail());
      if(aux != null){
          list.add(new FieldMessage("email", "Email já cadastrado"));
      }


        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
