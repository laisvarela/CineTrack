package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioController {
    public Usuario login(String username, String senha) {
        if (username.isBlank() || senha.isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else if (senha.length() < 4) {
            JOptionPane.showMessageDialog(null, "A senha deve ter pelo menos 4 caracteres.", "Atenção",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        } else {
            return new Usuario().login(username, senha);
        }

    }

    public void cadastrar(Usuario u) {
        if (u.getNome().isBlank() || u.getUsername().isBlank() || u.getSenha().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (u.getSenha().length() < 4) {
            JOptionPane.showMessageDialog(null, "A senha deve ter pelo menos 4 caracteres.", "Atenção",
                    JOptionPane.WARNING_MESSAGE);
        } else if (new Usuario().buscarPorUsername(u.getUsername()) != null) {
            JOptionPane.showMessageDialog(null, "Já existe um usuário com esse nome de usuário.", "Erro",
                    JOptionPane.ERROR_MESSAGE);

        } else if (u.getPerfil().equalsIgnoreCase("admin") && u.getCodigo() != 1234) {
            JOptionPane.showMessageDialog(null, "O código do administrador deve ser preenchido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            new Usuario().cadastrar(u);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void editar(int id, Usuario u) {
        new Usuario().editar(id, u);
    }

    public Usuario buscarPorId(int id) {
        return new Usuario().buscarPorId(id);
    }

    public Usuario buscarPorUsername(String username) {
        return new Usuario().buscarPorUsername(username);
    }

    public ArrayList<Usuario> listar() {
        return new Usuario().listar();
    }

    public void remover(int id) {
        new Usuario().remover(id);
    }
}
