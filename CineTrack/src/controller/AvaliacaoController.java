package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Avaliacao;

public class AvaliacaoController {

    public void cadastrar(Avaliacao a) {
        if (a.getUsuarioId() <= 0 || a.getFilmeId() <= 0 || a.getNota() < 1 || a.getNota() > 10
                || a.getComentario().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos corretamente.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (a.getNota() < 1 || a.getNota() > 10) {
            JOptionPane.showMessageDialog(null, "A nota deve ser de 1 a 10.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (new Avaliacao().buscar(a.getUsuarioId(), a.getFilmeId()) != null) {
            JOptionPane.showMessageDialog(null, "Já existe uma avaliação para este filme por este usuário.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (a != null) {
            new Avaliacao().cadastrar(a);
            JOptionPane.showMessageDialog(null, "Avaliação cadastrada com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void editar(int usuarioId, int filmeId, Avaliacao nova) {
        if (nova.getNota() < 1 || nova.getNota() > 10 || nova.getComentario().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos corretamente.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (new Avaliacao().buscar(usuarioId, filmeId) == null) {
            JOptionPane.showMessageDialog(null, "Avaliação não encontrada.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (nova != null) {
            new Avaliacao().editar(usuarioId, filmeId, nova);
            JOptionPane.showMessageDialog(null, "Avaliação editada com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Avaliacao buscar(int usuarioId, int filmeId) {
        if (usuarioId <= 0 || filmeId <= 0) {
            JOptionPane.showMessageDialog(null, "ID de usuário ou filme inválido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else if (new Avaliacao().buscar(usuarioId, filmeId) == null) {
            JOptionPane.showMessageDialog(null, "Avaliação não encontrada.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            return new Avaliacao().buscar(usuarioId, filmeId);
        }
    }

    public ArrayList<Avaliacao> listarPorUsuario(int usuarioId) {
        if (usuarioId <= 0) {
            JOptionPane.showMessageDialog(null, "ID de usuário inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        } else if (new Avaliacao().listarPorUsuario(usuarioId).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma avaliação encontrada para este usuário.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            return new ArrayList<>();
        } else {
            return new Avaliacao().listarPorUsuario(usuarioId);
        }

    }

    public void remover(int usuarioId, int filmeId) {
        if (usuarioId <= 0 || filmeId <= 0) {
            JOptionPane.showMessageDialog(null, "ID de usuário ou filme inválido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (new Avaliacao().buscar(usuarioId, filmeId) == null) {
            JOptionPane.showMessageDialog(null, "Avaliação não encontrada.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            new Avaliacao().remover(usuarioId, filmeId);
            JOptionPane.showMessageDialog(null, "Avaliação removida com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
