package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

/* @author lais.v */
public class UsuarioDAO {

    private Connection conn = null;
    private PreparedStatement stmt;
    private ResultSet rs;

    // retorna um objeto Usuario da tabela usuarios se encontrar o mesmo com username e senha passado por parametro
    public Usuario login(String username, String senha) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getString("perfil"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e);
        } finally {
            fechar();
        }
        return null;
    }
    
    // cadastra um novo usuario na tabela usuarios e retorna true caso tenha sucess e false se ocorrer erro
    public boolean cadastrar(Usuario u) {
        String sql = "INSERT INTO usuarios (nome, username, senha, perfil) VALUES (?, ?, ?, ?)";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e);
            return false;
        } finally {
            fechar();
        }
    }
    
    // edita na tabela usuarios os valores: nome, username e senha. Os novos valores são passados por paramentro
    public void editar(int id, Usuario u) {
        String sql = "UPDATE usuarios SET nome = ?, username = ?, senha = ?, WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Usuário editado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao editar usuário: " + e);
        } finally {
            fechar();
        }
    }
    
    // função editar do ADM, edita apenas o nome e username do usuário, nesse caso, o cliente
    public void ADMEditar(int id, Usuario u) {
        String sql = "UPDATE usuarios SET nome = ?, username = ? WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsername());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Usuário editado pelo ADM com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao ADM editar usuário: " + e);
        } finally {
            fechar();
        }
    }

    // busca na tabela usuarios o usuario encontrado através do id e retorna o mesmo
    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getString("perfil"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e);
        } finally {
            fechar();
        }
        return null;
    }

    // busca na tabela usuarios o usuario identificado pelo username e retorna o mesmo
    public Usuario buscarPorUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getString("perfil"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por username: " + e);
        } finally {
            fechar();
        }
        return null;
    }

    // retorna uma lista com todos os usuarios da tabela usuarios
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getString("perfil")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e);
        } finally {
            fechar();
        }
        return lista;
    }

    // remove o Usuario identificado pelo id passado por parametro 
    public void remover(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao remover usuário: " + e);
        } finally {
            fechar();
        }
    }

    // fecha as conexões 
    private void fechar() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar PreparedStatement: " + e);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e);
        }
    }

}
