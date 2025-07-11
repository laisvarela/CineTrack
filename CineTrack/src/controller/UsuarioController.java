package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Usuario;
import view.TelaLogin;

public class UsuarioController {

    public Usuario login(String username, char[] senha, Integer codigo) {
        if (username.isBlank() || senha.length == 0) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            String s = String.valueOf(senha);
            Usuario usuario = new Usuario().login(username, s);
            if (usuario != null) {
                if (usuario.getPerfil().equalsIgnoreCase("admin")) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, administrador " + usuario.getNome() + "!",
                            "Login bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
                    return usuario;
                } else {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, usuário " + usuario.getNome() + "!",
                            "Login bem-sucedido", JOptionPane.INFORMATION_MESSAGE);
                    TelaLogin.idLogado = usuario.getId();
                    return null;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }

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

        } else if (u.getPerfil().equalsIgnoreCase("admin") && u.getCodigoInformado() < u.getCodigo()
                || u.getCodigoInformado() > u.getCodigo()) {
            JOptionPane.showMessageDialog(null, "O código do administrador deve ser preenchido.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            if (u != null) {
                new Usuario().cadastrar(u);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void editar(int id, Usuario u) {
        if (u.getNome().isBlank() || u.getUsername().isBlank() || u.getSenha().isBlank()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (u.getSenha().length() < 4) {
            JOptionPane.showMessageDialog(null, "A senha deve ter pelo menos 4 caracteres.", "Atenção",
                    JOptionPane.WARNING_MESSAGE);
        } else if (u.getPerfil().equalsIgnoreCase("admin") && u.getCodigoInformado() < u.getCodigo()
                || u.getCodigoInformado() > u.getCodigo()) {
            JOptionPane.showMessageDialog(null, "Código de admin inválido!.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else if (new Usuario().buscarPorUsername(u.getUsername()) != null
                && new Usuario().buscarPorUsername(u.getUsername()).getId() != id) {
            JOptionPane.showMessageDialog(null, "Já existe um usuário com esse nome de usuário.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            new Usuario().editar(id, u);
            JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public Usuario buscarPorId(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            Usuario usuario = new Usuario().buscarPorId(id);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário encontrado: " + usuario.getNome(), "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Usuário encontrado: " + usuario.getNome());
                return usuario;
            }
        }
    }

    public Usuario buscarPorUsername(String username) {
        if (username.isBlank()) {
            JOptionPane.showMessageDialog(null, "O nome de usuário não pode estar vazio.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            Usuario usuario = new Usuario().buscarPorUsername(username);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário encontrado: " + usuario.getNome(), "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                return usuario;
            }
        }
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        if (new Usuario().listar().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.", "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            return usuarios;
        } else {
            usuarios = new Usuario().listar();
            JOptionPane.showMessageDialog(null, "Total de usuários cadastrados: " + usuarios.size(), "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
            return usuarios;
        }
    }

    public void remover(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Usuario usuario = new Usuario().buscarPorId(id);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                usuario.remover(id);
                JOptionPane.showMessageDialog(null, "Usuário removido: " + usuario.getNome(), "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
