package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/* @author lais.v */
public class ConexaoDAO {

    public static Connection ConectorBD() {
       
        try {
            String url = "jdbc:mysql://localhost:3306/mysql";
            String user = "laisv"; // seu usuário
            String password = "lais1234"; // sua senha

            // procura pelo driver adicionado na biblioteca, caso não tenha, siga as instruções de como adicionar pelo readme
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            criarTabelas(conn);
            return conn;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro na conexão com o banco: " + e);
            return null;
        }
    }
    
    // cria o banco de dados e as tabelas
    private static void criarTabelas(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS cinetrack");
            stmt.execute("USE cinetrack");
            // Tabela de usuários
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    nome VARCHAR(100),
                    username VARCHAR(40) UNIQUE,
                    senha VARCHAR(40),
                    perfil ENUM('admin', 'cliente') NOT NULL
                );
            """);
            // Tabela de filmes
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS filmes (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    titulo VARCHAR(100) NOT NULL,
                    genero VARCHAR(50),
                    diretor VARCHAR(100),
                    ano INT
                );
            """);

            // Tabela de avaliações (N:N)
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS avaliacoes (
                    usuario_id INT,
                    filme_id INT,
                    nota INT,
                    comentario TEXT,
                    PRIMARY KEY (usuario_id, filme_id),
                    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                    FOREIGN KEY (filme_id) REFERENCES filmes(id) ON DELETE CASCADE
                );
            """);

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e);
        }
    }
}
