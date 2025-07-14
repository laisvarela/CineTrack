package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Avaliacao;

/* @author lais.v */
public class AvaliacaoDAO {

    private Connection conn = null;
    private PreparedStatement stmt;
    private ResultSet rs;

    // cadastra na tabela de avaliacoes uma nova avaliação inserindo id do usuário avaliando, 
    // id do filme avaliado, nota inteira de 1 a 10 e comentário
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

    // edita na tabela avaliacoes a nota e o comentário, onde id de usuario e id de filme são passados por parametro
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
    
    // retorna um objeto Avaliacao da tabela avaliacoes identificado pelos valores passados por parametro
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

    // retorna uma lista do tipo Avaliacao do usuário, cujo id é passado por parametro
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

    // remove da tabela avaliacoes a avaliação correspondente os valores passados por parametro
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

    // fecha conexão
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
