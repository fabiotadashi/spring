package br.com.fiap.spring.controller;

import br.com.fiap.spring.model.dto.LivroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivroController {

    @GetMapping
    public List<LivroDTO> buscarLivros(@RequestParam(required = false, value = "titulo") String titulo){

        List<LivroDTO> livroDTOList = new ArrayList<>();

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(1);
        livroDTO.setTitulo("Aprenda Spring");
        livroDTO.setDescricao("Passo a passo com Spring Framework");
        livroDTO.setDataDePublicacao(new Date());
        livroDTO.setISBN("938472389472393482");

        livroDTOList.add(livroDTO);

        LivroDTO livroDTO1 = new LivroDTO();
        livroDTO1.setId(2);
        livroDTO1.setTitulo("Java");
        livroDTO1.setDescricao("Tudo sobre Java");
        livroDTO1.setDataDePublicacao(new Date());
        livroDTO1.setISBN("9548675464588");

        livroDTOList.add(livroDTO1);

        return livroDTOList.stream()
                .filter(dto -> titulo == null || dto.getTitulo().contains(titulo))
                .collect(Collectors.toList());
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

        livroDTOList.add(livroDTO);

        LivroDTO livroDTO1 = new LivroDTO();
        livroDTO1.setId(2);
        livroDTO1.setTitulo("Java");
        livroDTO1.setDescricao("Tudo sobre Java");
        livroDTO1.setDataDePublicacao(new Date());
        livroDTO1.setISBN("9548675464588");

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
    public LivroDTO criar(@RequestBody LivroDTO livroDTO){

        return livroDTO;
    }


}
