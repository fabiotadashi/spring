package br.com.fiap.spring.controller;

import br.com.fiap.spring.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.spring.model.dto.LivroDTO;
import br.com.fiap.spring.model.dto.UpdatePrecoLivroDTO;
import br.com.fiap.spring.model.entity.Livro;
import br.com.fiap.spring.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> buscarLivros(@RequestParam(required = false, value = "titulo") String titulo){
       return livroService.buscarLivros(titulo);
    }

    @GetMapping("{id}")
    public LivroDTO buscarPorId(@PathVariable int id) {

        List<LivroDTO> livroDTOList = new ArrayList<>();

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(1);
        livroDTO.setTitulo("Aprenda Spring");
        livroDTO.setDescricao("Passo a passo com Spring Framework");
        livroDTO.setDataDePublicacao(new Date());
        livroDTO.setISBN("938472389472393482");
        livroDTO.setPreco(20.4);

        livroDTOList.add(livroDTO);

        LivroDTO livroDTO1 = new LivroDTO();
        livroDTO1.setId(2);
        livroDTO1.setTitulo("Java");
        livroDTO1.setDescricao("Tudo sobre Java");
        livroDTO1.setDataDePublicacao(new Date());
        livroDTO1.setISBN("9548675464588");
        livroDTO1.setPreco(10.9);

        livroDTOList.add(livroDTO1);

        switch(id) {
            case 1:
                return livroDTO;
            case 2:
                return livroDTO1;
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Livro não encontrado");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO criar(@RequestBody CreateUpdateLivroDTO createUpdateLivroDTO){

        createUpdateLivroDTO.setTitulo(createUpdateLivroDTO.getTitulo());
        createUpdateLivroDTO.setDescricao(createUpdateLivroDTO.getDescricao());
        createUpdateLivroDTO.setISBN(createUpdateLivroDTO.getISBN());
        createUpdateLivroDTO.setDataDePublicacao(createUpdateLivroDTO.getDataDePublicacao());

        return livroService.criar(createUpdateLivroDTO);
    }

    @PutMapping("{id}")
    public LivroDTO atualizar(
            @PathVariable int id,
            @RequestBody CreateUpdateLivroDTO createUpdateLivroDTO
    ){

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(id);
        livroDTO.setTitulo(createUpdateLivroDTO.getTitulo());
        livroDTO.setDescricao(createUpdateLivroDTO.getDescricao());
        livroDTO.setISBN(createUpdateLivroDTO.getISBN());
        livroDTO.setDataDePublicacao(createUpdateLivroDTO.getDataDePublicacao());
        livroDTO.setPreco(createUpdateLivroDTO.getPreco());

        return livroDTO;
    }

    @PatchMapping("{id}/preco")
    public LivroDTO atualizarPreco(
            @PathVariable int id,
            @RequestBody UpdatePrecoLivroDTO updatePrecoLivroDTO
    ){

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(id);
        livroDTO.setPreco(updatePrecoLivroDTO.getPreco());

        return livroDTO;
    }


}
