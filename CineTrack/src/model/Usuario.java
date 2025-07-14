package model;

import java.util.ArrayList;
import dao.UsuarioDAO;

/* @author lais.v */
public class Usuario {

    private int id;
    private String nome;
    private String username;
    private String senha;
    private String perfil; // "admin" ou "cliente"
    private final Integer codigo = 1234;
    private Integer codigoInformado;// apenas se for admin (pode ser null para clientes)

    public Usuario() {
    }

    public Usuario(String nome, String username, String senha, String perfil, Integer codigoInformado) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.perfil = perfil;
        this.codigoInformado = codigoInformado;
    }

    public Usuario(String nome, String username, String senha, String perfil) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Usuario(int id, String nome, String username, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.perfil = perfil;
    }
    // Getters e Setters

    public Integer getCodigoInformado() {
        return codigoInformado;
    }

    public void setCodigoInformado(Integer codigoInformado) {
        this.codigoInformado = codigoInformado;
    }

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

    public boolean cadastrar(Usuario u) {
        return new UsuarioDAO().cadastrar(u);
    }

    public void editar(int id, Usuario u) {
        new UsuarioDAO().editar(id, u);
    }

    public void ADMEditar(int id, Usuario u) {
        new UsuarioDAO().ADMEditar(id, u);
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

    public Usuario login(String username, String senha) {
        return new UsuarioDAO().login(username, senha);
    }
}
