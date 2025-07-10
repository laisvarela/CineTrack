package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO {
    private Connection conn = null;
    private PreparedStatement stmt;
    private ResultSet rs;

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
                        rs.getString("perfil"),
                        rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e);
        } finally {
            fechar();
        }
        return null;
    }

    public void cadastrar(Usuario u) {
        String sql = "INSERT INTO usuarios (nome, username, senha, perfil, codigo) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());
            if ("admin".equals(u.getPerfil())) {
                stmt.setInt(5, u.getCodigo());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e);
        } finally {
            fechar();
        }
    }

    public void editar(int id, Usuario u) {
        String sql = "UPDATE usuarios SET nome = ?, username = ?, senha = ?, perfil = ?, codigo = ? WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getPerfil());
            if ("admin".equals(u.getPerfil())) {
                stmt.setInt(5, u.getCodigo());
            } else {
                stmt.setNull(5, 0);
            }
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Usuário editado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao editar usuário: " + e);
        } finally {
            fechar();
        }
    }

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
                        rs.getString("perfil"),
                        rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e);
        } finally {
            fechar();
        }
        return null;
    }

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
                        rs.getString("perfil"),
                        rs.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por username: " + e);
        } finally {
            fechar();
        }
        return null;
    }

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
                        rs.getString("perfil"),
                        rs.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e);
        } finally {
            fechar();
        }
        return lista;
    }

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

    private void fechar() {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar PreparedStatement: " + e);
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão: " + e);
        }
    }

}
