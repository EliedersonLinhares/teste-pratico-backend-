package com.esl.candidato.services.validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.esl.candidato.Resource.exceptions.FieldMessage;
import com.esl.candidato.domain.Candidato;
import com.esl.candidato.dto.CandidatoDTO;
import com.esl.candidato.repositories.CandidatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class CandidatoUpdateValidator implements ConstraintValidator<CandidatoUpdate, CandidatoDTO> {
   
   @Autowired
   private HttpServletRequest request;

   @Autowired
   private CandidatoRepository repo; 
   
    @Override
    public void initialize(CandidatoUpdate ann) {
    }

    @Override
    public boolean isValid(CandidatoDTO objDto, ConstraintValidatorContext context) {
      
       
        
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

       List<FieldMessage> list = new ArrayList<>();
      Candidato aux = repo.findByEmail(objDto.getEmail());
      if(aux != null && !aux.getId().equals(uriId)){
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
