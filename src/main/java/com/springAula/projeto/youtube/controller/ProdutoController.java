package com.springAula.projeto.youtube.controller;

import com.springAula.projeto.youtube.model.Produto;
import com.springAula.projeto.youtube.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping("/salvar")
    ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @GetMapping("/buscarTodos")
    ResponseEntity<List<Produto>> buscarTodos(){
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/buscarPorId/{id}")
    ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PutMapping("/alterarProduto")
    ResponseEntity<Produto> alterarProduto(@RequestParam Long id, @RequestParam String nome, @RequestParam Double preco ){
        return ResponseEntity.ok(produtoService.autalizaProduto(id, nome, preco));
    }

    @DeleteMapping("/DeletarProduto/{id}")
    ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletaProdutoPorID(id);
        return ResponseEntity.ok().build();
    }

}
