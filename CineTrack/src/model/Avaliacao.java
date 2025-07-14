package model;

import java.util.ArrayList;
import dao.AvaliacaoDAO;

/* @author lais.v */
public class Avaliacao {

    private int usuarioId;
    private int filmeId;
    private int nota; // de 1 a 10
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(int usuarioId, int filmeId, int nota, String comentario) {
        this.usuarioId = usuarioId;
        this.filmeId = filmeId;
        this.nota = nota;
        this.comentario = comentario;
    }

    // Getters e Setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(int filmeId) {
        this.filmeId = filmeId;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void cadastrar(Avaliacao a) {
        new AvaliacaoDAO().cadastrar(a);
    }

    public void editar(int usuarioId, int filmeId, Avaliacao nova) {
        new AvaliacaoDAO().editar(usuarioId, filmeId, nova);
    }

    public Avaliacao buscar(int usuarioId, int filmeId) {
        return new AvaliacaoDAO().buscar(usuarioId, filmeId);
    }

    public ArrayList<Avaliacao> listarPorUsuario(int usuarioId) {
        return new AvaliacaoDAO().listarPorUsuario(usuarioId);
    }

    public void remover(int usuarioId, int filmeId) {
        new AvaliacaoDAO().remover(usuarioId, filmeId);
    }
}
