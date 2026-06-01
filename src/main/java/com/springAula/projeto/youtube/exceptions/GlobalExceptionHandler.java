package com.springAula.projeto.youtube.exceptions;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

//Classe totalmente feita pelo professor
@RestControllerAdvice
public class GlobalExceptionHandler{

        @ExceptionHandler(RecursoNaoEncontradoException.class)
        public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex){

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("Status", HttpStatus.NOT_FOUND.value());
            body.put("error" , "Recurso não encontrado");
            body.put("message", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleGenericException(Exception ex){

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            body.put("error" , "Erro interno do servidor");
            body.put("message", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        @ExceptionHandler(UnexpectedTypeException.class)
        public ResponseEntity<Object> handleGenericException(UnexpectedTypeException ex){

            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("Status", HttpStatus.BAD_REQUEST.value());
            body.put("error" , "Dados não formatos de forma correta");
            body.put("message", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

        }


}
