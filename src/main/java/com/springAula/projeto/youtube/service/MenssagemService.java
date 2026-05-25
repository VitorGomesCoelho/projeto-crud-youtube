package com.springAula.projeto.youtube.service;

import com.springAula.projeto.youtube.repository.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MenssagemService {

    private final MensagemRepository mensagemRepository;

    public MenssagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;

    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }

}
