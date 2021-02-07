package br.com.fiap.spring.model.entity;

import br.com.fiap.spring.model.dto.CreateUpdateLivroDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String ISBN;

    @Column
    private double preco;

    @Column
    private Date dataDePublicacao;

    public Livro(){}

    public Livro(CreateUpdateLivroDTO createUpdateLivroDTO) {
        this.titulo = createUpdateLivroDTO.getTitulo();
        this.descricao = createUpdateLivroDTO.getDescricao();
        this.dataDePublicacao = createUpdateLivroDTO.getDataDePublicacao();
        this.ISBN = createUpdateLivroDTO.getISBN();
        this.preco = createUpdateLivroDTO.getPreco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(Date dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
