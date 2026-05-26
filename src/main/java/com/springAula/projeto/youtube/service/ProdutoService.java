package com.springAula.projeto.youtube.service;

import com.springAula.projeto.youtube.model.Produto;
import com.springAula.projeto.youtube.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    //Métodos
    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public Produto autalizaProduto(Long id, String nome, Double preco){

       Produto produto = produtoRepository.findById(id).orElseThrow();

       produto.setNome(nome);
       produto.setPreco(preco);

       return produtoRepository.save(produto);

    }

    public void deletaProdutoPorID(Long id){
        produtoRepository.deleteById(id);
    }



}
