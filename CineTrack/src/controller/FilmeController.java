package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Filme;

public class FilmeController {
    public void cadastrar(Filme f) {
        if (f.getTitulo().isBlank() || f.getGenero().isBlank() || f.getDiretor().isBlank() || f.getAno() <= 0) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (f.getAno() < 1888 || f.getAno() > java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)) {
            JOptionPane.showMessageDialog(null, "O ano do filme deve ser válido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } else if (new Filme().buscarPorTitulo(f.getTitulo()) != null) {
            JOptionPane.showMessageDialog(null, "Já existe um filme com esse título.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } else if (f != null) {
            new Filme().cadastrar(f);
            System.out.println("Filme cadastrado com sucesso!");
        }
    }

    public void editar(int id, Filme f) {
        if (f.getTitulo().isBlank() || f.getGenero().isBlank() || f.getDiretor().isBlank() || f.getAno() <= 0) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (f.getAno() < 1888 || f.getAno() > java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)) {
            JOptionPane.showMessageDialog(null, "O ano do filme deve ser válido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } else if (new Filme().buscarPorTitulo(f.getTitulo()) != null
                && new Filme().buscarPorTitulo(f.getTitulo()).getId() != id) {
            JOptionPane.showMessageDialog(null, "Já existe um filme com esse título.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } else if (new Filme().buscarPorId(id) == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (f != null) {
            new Filme().editar(id, f);
            JOptionPane.showMessageDialog(null, "Filme editado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme editado com sucesso!");
        }

    }

    public Filme buscarPorId(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Filme filme = new Filme().buscarPorId(id);
        if (filme == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            JOptionPane.showMessageDialog(null, "Filme encontrado: " + filme.getTitulo(), "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme encontrado: " + filme.getTitulo());
            return filme;
        }

    }

    public Filme buscarPorTitulo(String titulo) {
        if (titulo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Título não pode ser vazio.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Filme filme = new Filme().buscarPorTitulo(titulo);
        if (filme == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            JOptionPane.showMessageDialog(null, "Filme encontrado: " + filme.getTitulo(), "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme encontrado: " + filme.getTitulo());
            return filme;
        }
    }

    public ArrayList<Filme> listar() {
        if (new Filme().listar().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum filme cadastrado.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            return new ArrayList<>();
        } else {
            JOptionPane.showMessageDialog(null, "Total de filmes cadastrados: " + new Filme().listar().size(),
                    "Informação", JOptionPane.INFORMATION_MESSAGE);
            return new Filme().listar();
        }

    }

    public void remover(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (new Filme().buscarPorId(id) == null) {
            JOptionPane.showMessageDialog(null, "Filme não encontrado.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            new Filme().remover(id);
            JOptionPane.showMessageDialog(null, "Filme removido com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme removido com sucesso!");
        }
    }
}
