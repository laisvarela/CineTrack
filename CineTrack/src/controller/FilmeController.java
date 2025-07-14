package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Filme;

/* @author lais.v */
public class FilmeController {

    // cadastra um novo filme caso os valores de Filme f sejam válidos
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

        } else {
            new Filme().cadastrar(f);
            System.out.println("Filme cadastrado com sucesso!");
        }
    }

    // edita o Filme com id correspondente ao passado por parametro, caso os valores de Filme f sejam válidos
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
        } else {
            new Filme().editar(id, f);
            JOptionPane.showMessageDialog(null, "Filme editado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Filme editado com sucesso!");
        }

    }

    // retorna um Filme caso o id seja válido
    public Filme buscarPorId(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Filme filme = new Filme().buscarPorId(id);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return null;
        } else {
            System.out.println("Filme encontrado: " + filme.getTitulo());
            return filme;
        }

    }
    // retorna um Filme caso o título seja válido e neste sistema, não é possível cadastrar dois títulos iguais
    public Filme buscarPorTitulo(String titulo) {
        if (titulo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Título não pode ser vazio.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Filme filme = new Filme().buscarPorTitulo(titulo);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return null;
        } else {
            System.out.println("Filme encontrado: " + filme.getTitulo());
            return filme;
        }
    }

    // retorna uma lista de filmes 
    public ArrayList<Filme> listar() {
        if (new Filme().listar().isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return new ArrayList<>();
        } else {
            System.out.println("Total de filmes cadastrados: " + new Filme().listar().size());
            return new Filme().listar();
        }

    }

    // remove o filme com id correspondente ao id passado por parametro, caso id seja válido
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
