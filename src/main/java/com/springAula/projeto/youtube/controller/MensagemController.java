package com.springAula.projeto.youtube.controller;

import com.springAula.projeto.youtube.service.MenssagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MensagemController {

    final MenssagemService menssagemService;

    public MensagemController(MenssagemService menssagemService){
        this.menssagemService = menssagemService;
    }

    @GetMapping("/mensagem")
    public String mensagem() {
        return menssagemService.obterMensagem();
    }

}
