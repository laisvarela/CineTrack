package view;

import model.Usuario;

public class main {
    public static void main(String[] args) {
        // Iniciar a aplicação
        
        Usuario usuario = new Usuario();
        System.out.println(usuario.buscarPorId(1));
        
    }
}
