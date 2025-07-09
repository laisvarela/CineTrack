package controller;

import java.util.ArrayList;

import model.Filme;

public class FilmeController {
    public void cadastrar(Filme f) {
        new Filme().cadastrar(f);
    }

    public void editar(int id, Filme f) {
        new Filme().editar(id, f);
    }

    public Filme buscarPorId(int id) {
        return new Filme().buscarPorId(id);

    }

    public Filme buscarPorTitulo(String titulo) {
        return new Filme().buscarPorTitulo(titulo);
    }

    public ArrayList<Filme> listar() {
        return new Filme().listar();
    }

    public void remover(int id) {
        new Filme().remover(id);
    }
}
