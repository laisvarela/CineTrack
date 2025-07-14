package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filme;

/* @author lais.v */

public class FilmeDAO {
    private Connection conn = null;
    private PreparedStatement stmt;
    private ResultSet rs;

    // cadastra filme no banco de dados na tabela filmes, inserindo título, genero, diretor e ano
    public void cadastrar(Filme f) {
        String sql = "INSERT INTO filmes (titulo, genero, diretor, ano) VALUES (?, ?, ?, ?)";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getTitulo());
            stmt.setString(2, f.getGenero());
            stmt.setString(3, f.getDiretor());
            stmt.setInt(4, f.getAno());
            stmt.executeUpdate();
            System.out.println("Filme cadastrado no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar filme: " + e);
        } finally {
            fechar();
        }
    }

    // edita na tabela filmes os valores: título, gênero, diretor e ano
    public void editar(int id, Filme f) {
        String sql = "UPDATE filmes SET titulo = ?, genero = ?, diretor = ?, ano = ? WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, f.getTitulo());
            stmt.setString(2, f.getGenero());
            stmt.setString(3, f.getDiretor());
            stmt.setInt(4, f.getAno());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Filme editado no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao editar filme: " + e);
        } finally {
            fechar();
        }
    }

    // busca na tabela filmes o id passado por parametro e retorna um objeto Filme
    public Filme buscarPorId(int id) {
        String sql = "SELECT * FROM filmes WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Filme(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("diretor"),
                        rs.getInt("ano"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar filme: " + e);
        } finally {
            fechar();
        }
        return null;
    }

    // lista todos os objetos Filme da tablea filmes
    public ArrayList<Filme> listar() {
        ArrayList<Filme> lista = new ArrayList<>();
        String sql = "SELECT * FROM filmes";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Filme(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("diretor"),
                        rs.getInt("ano")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar filmes: " + e);
        } finally {
            fechar();
        }
        return lista;
    }
    
    // remove o objeto Filme da tabela filmes de acordo com o id passado por parametro
    public void remover(int id) {
        String sql = "DELETE FROM filmes WHERE id = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao remover filme: " + e);
        } finally {
            fechar();
        }
    }

    // busca o filme pelo título na tabela filmes e retorna um objeto Filme
    public Filme buscarPorTitulo(String titulo) {
        String sql = "SELECT * FROM filmes WHERE titulo = ?";
        try {
            conn = ConexaoDAO.ConectorBD();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Filme(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getString("diretor"),
                        rs.getInt("ano"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar filme por título: " + e);
        } finally {
            fechar();
        }
        return null;
    }
    
    // fecha as conexões
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
