package com.springAula.projeto.youtube.service;

import com.springAula.projeto.youtube.exceptions.DadosIncorretosException;
import com.springAula.projeto.youtube.exceptions.RecursoNaoEncontradoException;
import com.springAula.projeto.youtube.model.Produto;
import com.springAula.projeto.youtube.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    //Construtor
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //Métodos
    public Produto salvarProduto(Produto produto){
        /*if(produto.getNome().isBlank()){
            throw new DadosIncorretosException("Dados incorretos ou não informados");
        }*/

        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        if(produtoRepository.findAll().isEmpty()){
            throw new RecursoNaoEncontradoException("Nenhum dado encontrado");

        }
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Produto com o ID: "+id+" não encontrado!"));
    }

    public Produto autalizaProduto(Long id, String nome, Double preco){

       Produto produto = produtoRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Produto com o ID: "+id+" não encontrado!"));

       produto.setNome(nome);
       produto.setPreco(preco);

       return produtoRepository.save(produto);

    }

    public void deletaProdutoPorID(Long id){

            if (!produtoRepository.existsById(id)){
                throw new RecursoNaoEncontradoException("Produto com o ID: "+id+" não encontrado!");
            }
            produtoRepository.deleteById(id);
    }



}
