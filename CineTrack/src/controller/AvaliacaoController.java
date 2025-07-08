package controller;

import java.util.ArrayList;

import model.Avaliacao;

public class AvaliacaoController {
    public void cadastrar(Avaliacao a) {
        
    }

    public void editar(int usuarioId, int filmeId, Avaliacao nova) {
        new Avaliacao().editar(usuarioId, filmeId, nova);
    }

    public Avaliacao buscar(int usuarioId, int filmeId) {
        return new Avaliacao().buscar(usuarioId, filmeId);
    }

    public ArrayList<Avaliacao> listarPorUsuario(int usuarioId) {
        return new Avaliacao().listarPorUsuario(usuarioId);
    }

    public void remover(int usuarioId, int filmeId) {
        new Avaliacao().remover(usuarioId, filmeId);
    }
}
