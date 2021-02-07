package br.com.fiap.spring.repository;

import br.com.fiap.spring.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("from Livro l " +
            "where l.titulo like %:titulo%")
    List<Livro> buscaPorTitulo(String titulo);

    List<Livro> findAllByTituloLike(String titulo);

}
