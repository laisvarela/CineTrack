/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Usuario;

/**
 *
 * @author Jao
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MDI
     */
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setInitialState();
        addMenuActions();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        menuLogado = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        menuItemGerenciarClientes = new javax.swing.JMenuItem();
        menutItemGerenciarFilmes = new javax.swing.JMenuItem();
        menuAvaliacoes = new javax.swing.JMenu();
        menuItemAvaliarFilme = new javax.swing.JMenuItem();
        menuSistema = new javax.swing.JMenu();
        menuItemRelatorio = new javax.swing.JMenuItem();
        menuConta = new javax.swing.JMenu();
        menuItemEditarConta = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(176, 224, 230));
        desktopPane.setMaximumSize(new java.awt.Dimension(0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(70, 130, 180));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pipoca.png"))); // NOI18N
        jLabel1.setText("Bem-Vindo ao CineTrack");

        btnLogin.setBackground(new java.awt.Color(70, 130, 180));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(245, 255, 250));
        btnLogin.setText("Entrar");
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        menuCadastros.setBackground(new java.awt.Color(0, 0, 0));
        menuCadastros.setText("Cadastros");

        menuItemGerenciarClientes.setText("Gerenciar Clientes");
        menuCadastros.add(menuItemGerenciarClientes);

        menutItemGerenciarFilmes.setBackground(new java.awt.Color(0, 0, 0));
        menutItemGerenciarFilmes.setText("Gerenciar Filmes");
        menuCadastros.add(menutItemGerenciarFilmes);

        menuLogado.add(menuCadastros);

        menuAvaliacoes.setText("Avaliações");

        menuItemAvaliarFilme.setText("Avaliar Filme");
        menuAvaliacoes.add(menuItemAvaliarFilme);

        menuLogado.add(menuAvaliacoes);

        menuSistema.setText("Sistema");

        menuItemRelatorio.setText("Relatório");
        menuSistema.add(menuItemRelatorio);

        menuLogado.add(menuSistema);

        menuConta.setText("Conta");

        menuItemEditarConta.setText("Editar Conta");
        menuConta.add(menuItemEditarConta);

        menuItemLogout.setText("Logout");
        menuConta.add(menuItemLogout);

        menuLogado.add(menuConta);

        setJMenuBar(menuLogado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private void setInitialState() {

        menuCadastros.setVisible(false);
        menuSistema.setVisible(false);
        menuConta.setVisible(false);
        menuAvaliacoes.setVisible(false);

        desktopPane.removeAll();
        desktopPane.add(jLabel1);
        desktopPane.add(btnLogin);
        jLabel1.setVisible(true);
        btnLogin.setVisible(true);
        revalidate();
        repaint();
    }

    private void addMenuActions() {
        // Ação para Gerenciar Filmes (Admin)
        menutItemGerenciarFilmes.addActionListener(e -> {
            TelaCadastroFilme tela = new TelaCadastroFilme();
            desktopPane.add(tela);
            tela.setVisible(true);
        });

        // Ação para Gerenciar Clientes (Admin)
        menuItemGerenciarClientes.addActionListener(e -> {
            TelaCadastroUsuario tela = new TelaCadastroUsuario();
            desktopPane.add(tela);
            tela.setVisible(true);
        });

        menuItemAvaliarFilme.addActionListener(e -> {
            TelaAvaliacaoFilme tela = new TelaAvaliacaoFilme();
            desktopPane.add(tela);
            tela.setVisible(true);
        });

        menuItemRelatorio.addActionListener(e -> {
            TelaRelatorio tela = new TelaRelatorio();
            desktopPane.add(tela);
            tela.setVisible(true);
        });

        menuItemEditarConta.addActionListener(e -> {
            TelaEditarConta tela = new TelaEditarConta();
            desktopPane.add(tela);
            tela.setVisible(true);
        });

        menuItemLogout.addActionListener(e -> {
            for (JInternalFrame frame : desktopPane.getAllFrames()) {
                frame.dispose();
            }
            setInitialState();
        });
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        TelaLogin telaLogin = new TelaLogin(this, this.desktopPane);
        desktopPane.add(telaLogin);
        telaLogin.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }//GEN-LAST:event_btnLoginActionPerformed
    public void onLoginSuccess(Usuario usuario) {
        
        jLabel1.setVisible(false);
        btnLogin.setVisible(false);

        if ("admin".equals(usuario.getPerfil())) {
            menuCadastros.setVisible(true); 
            menuSistema.setVisible(true);
            menuConta.setVisible(true);
            menuAvaliacoes.setVisible(false);
        } else if ("cliente".equals(usuario.getPerfil())) {
            menuAvaliacoes.setVisible(true);
            menuConta.setVisible(true);
            menuCadastros.setVisible(false);
            menuSistema.setVisible(false);
        }
        revalidate();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu menuAvaliacoes;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenuItem menuItemAvaliarFilme;
    private javax.swing.JMenuItem menuItemEditarConta;
    private javax.swing.JMenuItem menuItemGerenciarClientes;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemRelatorio;
    private javax.swing.JMenuBar menuLogado;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenuItem menutItemGerenciarFilmes;
    // End of variables declaration//GEN-END:variables

}
