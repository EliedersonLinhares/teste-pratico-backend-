package com.esl.candidato.Resource;

import java.net.URI;

import javax.validation.Valid;

import com.esl.candidato.domain.Perfil;
import com.esl.candidato.dto.PerfilDTO;
import com.esl.candidato.services.PerfilServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

      @Autowired
      private PerfilServices service;

      @ApiOperation(value="Insere um perfil")
      @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid@RequestBody PerfilDTO objDto){
		
	
		Perfil obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


      @ApiOperation(value="Apaga um perfil por id")
     @PreAuthorize("hasAnyRole('ADMIN')")
      @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
      public ResponseEntity<Void> delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
      }

      @ApiOperation(value="Atualiza um perfil por id")
        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Void> update(@Valid @RequestBody PerfilDTO objDto, @PathVariable Integer id) {
           Perfil obj = service.fromDTO(objDto);
            obj.setId(id);
            obj = service.update(obj);
            return ResponseEntity.noContent().build();
      }
      
}
