package br.com.fiap.spring.service;

import br.com.fiap.spring.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.spring.model.dto.LivroDTO;
import br.com.fiap.spring.model.dto.UpdatePrecoLivroDTO;

import java.util.List;

public interface LivroService {

    List<LivroDTO> buscarLivros(String titulo);
    LivroDTO buscarPorId(int id);
    LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO);
    LivroDTO atualizar(CreateUpdateLivroDTO stockCreateUpdateDTO, int id);
    LivroDTO atualizarPreco(UpdatePrecoLivroDTO updatePrecoLivroDTO, int id);
    void delete(int id);

}
