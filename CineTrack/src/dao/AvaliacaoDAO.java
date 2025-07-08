package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Avaliacao;

public class AvaliacaoDAO {
    private Connection conn = null;
    private PreparedStatement stmt;
    private ResultSet rs;

    public void cadastrar(Avaliacao a) {
        String sql = "INSERT INTO avaliacoes (usuario_id, filme_id, nota, comentario) VALUES (?, ?, ?, ?)";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, a.getUsuarioId());
            stmt.setInt(2, a.getFilmeId());
            stmt.setInt(3, a.getNota());
            stmt.setString(4, a.getComentario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar avaliação: " + e);
        } finally {
            fechar();
        }
    }

    public void editar(int usuarioId, int filmeId, Avaliacao nova) {
        String sql = "UPDATE avaliacoes SET nota = ?, comentario = ? WHERE usuario_id = ? AND filme_id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, nova.getNota());
            stmt.setString(2, nova.getComentario());
            stmt.setInt(3, usuarioId);
            stmt.setInt(4, filmeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao editar avaliação: " + e);
        } finally {
            fechar();
        }
    }

    public Avaliacao buscar(int usuarioId, int filmeId) {
        String sql = "SELECT * FROM avaliacoes WHERE usuario_id = ? AND filme_id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, filmeId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Avaliacao(
                        rs.getInt("usuario_id"),
                        rs.getInt("filme_id"),
                        rs.getInt("nota"),
                        rs.getString("comentario"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar avaliação: " + e);
        } finally {
            fechar();
        }
        return null;
    }

    public ArrayList<Avaliacao> listarPorUsuario(int usuarioId) {
        ArrayList<Avaliacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM avaliacoes WHERE usuario_id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Avaliacao(
                        rs.getInt("usuario_id"),
                        rs.getInt("filme_id"),
                        rs.getInt("nota"),
                        rs.getString("comentario")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar avaliações: " + e);
        } finally {
            fechar();
        }
        return lista;
    }

    public void remover(int usuarioId, int filmeId) {
        String sql = "DELETE FROM avaliacoes WHERE usuario_id = ? AND filme_id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, filmeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao remover avaliação: " + e);
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
