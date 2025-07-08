package model;

import java.util.ArrayList;

import dao.UsuarioDAO;

public class Usuario {
    private int id;
    private String nome;
    private String username;
    private String senha;
    private String perfil; // "admin" ou "cliente"
    private Integer codigo; // apenas se for admin (pode ser null para clientes)

    public Usuario() {
    }

    public Usuario(int id, String nome, String username, String senha, String perfil, Integer codigo) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.perfil = perfil;
        this.codigo = codigo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void cadastrar(Usuario u) {
        new UsuarioDAO().cadastrar(u);
    }

    public void editar(int id, Usuario u) {
        new UsuarioDAO().editar(id, u);
    }

    public Usuario buscarPorId(int id) {
        return new UsuarioDAO().buscarPorId(id);
    }

    public Usuario buscarPorUsername(String username) {
        return new UsuarioDAO().buscarPorUsername(username);
    }

    public ArrayList<Usuario> listar() {
        return new UsuarioDAO().listar();
    }

    public void remover(int id) {
        new UsuarioDAO().remover(id);
    }
}