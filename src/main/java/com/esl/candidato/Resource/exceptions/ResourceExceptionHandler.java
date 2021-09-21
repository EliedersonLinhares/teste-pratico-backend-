package com.esl.candidato.Resource.exceptions;


import javax.servlet.http.HttpServletRequest;

import com.esl.candidato.services.exceptions.AuthorizationException;
import com.esl.candidato.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Anotação que permite que se escreva um codigo global para ser aplicado a diferentes controlers ref: https://dzone.com/articles/global-exception-handling-with-controlleradvice
public class ResourceExceptionHandler { //classe auxiliar que intercepta as excessões 
	
	@ExceptionHandler(ObjectNotFoundException.class)//anotado como tratador de excessões
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest  request){//Metodo que recebe a exceção,com as informações da requisição

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());//novo formato padronizado
				//passar os dados do erro; HttpStatus.NOT_FOUND(erro 204)
		
	     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	     
	}     
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)//anotado como tratador de excessões
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest  request){//Metodo que recebe a exceção,com as informações da requisição

		
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", "Campos preenchidos erroneamente", request.getRequestURI());//novo formato padronizado
		
		/*
		 * For para percorrer a lista de erros que tem nessa excessão "e", e para cada erro que estiver 
		 * na lista de erros dessa excessão é gerado o objeto FieldMessage
		 * 
		 * e.getBindingResult().getFieldErrors() -> Acessa todos os campos de erros que aconteceram na escessão  MethodArgumentNotValidException
		 */
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		
	     return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	     
	}

	@ExceptionHandler(AuthorizationException.class)//anotado como tratador de excessões
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest  request){//Metodo que recebe a exceção,com as informações da requisição

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Falha na Autorização", e.getMessage(), request.getRequestURI());//novo formato padronizado
				//passar os dados do erro; HttpStatus.NOT_FOUND(erro 204)
		
	     return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	     
	}
}