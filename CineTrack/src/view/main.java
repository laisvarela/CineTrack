package view;

import model.Usuario;

public class main {
    public static void main(String[] args) {
        // Iniciar a aplicação
        Usuario usuario = new Usuario();
        usuario.setNome("Lais");
        usuario.setUsername("laisv");
        usuario.setSenha("123456");
        usuario.setPerfil("admin");
        usuario.setCodigo(1234);
        usuario.cadastrar(usuario);
    }
}
