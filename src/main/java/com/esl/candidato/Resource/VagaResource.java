package com.esl.candidato.Resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.esl.candidato.domain.Vaga;
import com.esl.candidato.dto.VagaDTO;
import com.esl.candidato.services.VagaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/vaga")
public class VagaResource {

      @Autowired
      private VagaServices service;

      @ApiOperation(value="Busca por id")
      @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public ResponseEntity<Vaga> find(@PathVariable Integer id) {
            Vaga obj = service.find(id);
            return ResponseEntity.ok().body(obj);
      }

      @ApiOperation(value="Insere uma vaga")
      @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid@RequestBody VagaDTO objDto){
		
	
		Vaga obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}


      @ApiOperation(value="Apaga uma vaga por id")
     @PreAuthorize("hasAnyRole('ADMIN')")
      @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
      public ResponseEntity<Void> delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
      }

      @ApiOperation(value="Busca por todas as vagas")
     @PreAuthorize("hasAnyRole('ADMIN')")
      @RequestMapping(method = RequestMethod.GET)
      public ResponseEntity<List<VagaDTO>> findAll() {
            List<Vaga> list = service.findAll();
            List<VagaDTO> listdto = list.stream().map(obj -> new VagaDTO(obj)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listdto);
      }

      @ApiOperation(value="Busca por todos vagas com paginação")
     @PreAuthorize("hasAnyRole('ADMIN')")
      @RequestMapping(value="/page", method = RequestMethod.GET)
      public ResponseEntity<Page<VagaDTO>> findPage(
           @RequestParam(value = "page", defaultValue = "0") Integer page, 
           @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
           @RequestParam(value = "orderBy", defaultValue = "name")String orderBy,
           @RequestParam(value = "direction", defaultValue = "ASC")  String direction) {
            Page<Vaga> list = service.findPage(page, linesPerPage, orderBy, direction);
            Page<VagaDTO> listdto = list.map(obj -> new VagaDTO(obj));
            return ResponseEntity.ok().body(listdto);
      }

      
      @ApiOperation(value="Atualiza um perfil por id")
        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Void> update(@Valid @RequestBody VagaDTO objDto, @PathVariable Integer id) {
            Vaga obj = service.fromDTO(objDto);
            obj.setId(id);
            obj = service.update(obj);
            return ResponseEntity.noContent().build();
      }
      
}
