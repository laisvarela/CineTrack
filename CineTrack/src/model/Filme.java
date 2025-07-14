package model;

import java.util.ArrayList;
import dao.FilmeDAO;

/* @author lais.v */
public class Filme {

    private int id;
    private String titulo;
    private String genero;
    private String diretor;
    private int ano;

    public Filme(String titulo, String genero, String diretor, int ano) {
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.ano = ano;
    }

    public Filme() {
    }

    public Filme(int id, String titulo, String genero, String diretor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.ano = ano;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void cadastrar(Filme f) {
        new FilmeDAO().cadastrar(f);
    }

    public void editar(int id, Filme f) {
        new FilmeDAO().editar(id, f);
    }

    public Filme buscarPorId(int id) {
        return new FilmeDAO().buscarPorId(id);
    }

    public Filme buscarPorTitulo(String titulo) {
        return new FilmeDAO().buscarPorTitulo(titulo);
    }

    public ArrayList<Filme> listar() {
        return new FilmeDAO().listar();
    }

    public void remover(int id) {
        new FilmeDAO().remover(id);
    }

}
