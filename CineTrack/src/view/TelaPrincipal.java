package view;

import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import model.Usuario;

/**
 *
 * @author Jao
 * @author lais.v
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        bemvindo_Panel = new javax.swing.JLayeredPane();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        desktopPane.setBackground(new java.awt.Color(0, 51, 51));
        desktopPane.setMaximumSize(new java.awt.Dimension(0, 0));

        bemvindo_Panel.setBackground(new java.awt.Color(0, 102, 102));
        bemvindo_Panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bemvindo_Panel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        bemvindo_Panel.setOpaque(true);

        btnLogin.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 51, 102));
        btnLogin.setText("Entrar");
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pipoca.png"))); // NOI18N
        jLabel1.setText("Bem-Vindo ao CineTrack");

        bemvindo_Panel.setLayer(btnLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bemvindo_Panel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bemvindo_PanelLayout = new javax.swing.GroupLayout(bemvindo_Panel);
        bemvindo_Panel.setLayout(bemvindo_PanelLayout);
        bemvindo_PanelLayout.setHorizontalGroup(
            bemvindo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bemvindo_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bemvindo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bemvindo_PanelLayout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)))
                .addContainerGap())
        );
        bemvindo_PanelLayout.setVerticalGroup(
            bemvindo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bemvindo_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        desktopPane.setLayer(bemvindo_Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(bemvindo_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(bemvindo_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
     public void setInitialState() {
        desktopConfig();
        desktopPane.add(bemvindo_Panel);
        bemvindo_Panel.setVisible(true);
        menuLogado.setVisible(false);

    }

    private void addMenuActions() {
        // Ação para Gerenciar Filmes (Admin)
        menutItemGerenciarFilmes.addActionListener(e -> {
            abrirUnicoFrame(new TelaCadastroFilme());
        });

        // Ação para Gerenciar Clientes (Admin)
        menuItemGerenciarClientes.addActionListener(e -> {
            TelaCadastroUsuario tela = new TelaCadastroUsuario(this);
            tela.tabela_Panel.setVisible(true);
            tela.pack();
            abrirUnicoFrame(tela);
        });

        menuItemAvaliarFilme.addActionListener(e -> {
            abrirUnicoFrame(new TelaAvaliacaoFilme());
        });

        menuItemRelatorio.addActionListener(e -> {
            abrirUnicoFrame(new TelaRelatorio());
        });

        menuItemEditarConta.addActionListener(e -> {
            abrirUnicoFrame(new TelaEditarConta());
        });

        menuItemLogout.addActionListener(e -> {
            setInitialState();
        });
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        abrirUnicoFrame(new TelaLogin(this));
    }//GEN-LAST:event_btnLoginActionPerformed

    public void onLoginSuccess(Usuario usuario) {
        desktopConfig();
        menuLogado.setVisible(true);
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
    }

    public void telaCadastro() {
        abrirUnicoFrame(new TelaCadastroUsuario(this));
        System.out.println("Frames abertos: " + desktopPane.getAllFrames().length);
    }

    public void desktopConfig() {
        desktopPane.removeAll();
        desktopPane.repaint();
        desktopPane.revalidate();
    }

    public void abrirUnicoFrame(JInternalFrame novoFrame) {
        desktopConfig();

        // Prepara novo frame
        novoFrame.pack();

        // Adiciona ao desktopPane
        desktopPane.add(novoFrame);
        novoFrame.setVisible(true);
        novoFrame.moveToFront();
        novoFrame.requestFocusInWindow();
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
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bemvindo_Panel;
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
