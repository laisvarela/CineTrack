package view;

import controller.*;
import model.Usuario;

/**
 *
 * @author Jao
 */
public class TelaLogin extends javax.swing.JInternalFrame {

    private TelaPrincipal parentFrame;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaLogin.class.getName());
    public static int idLogado;

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin(TelaPrincipal parent, javax.swing.JDesktopPane desktopPane) {
        initComponents();
        this.parentFrame = parent;
        this.desktopPane = desktopPane;
        codigo_label.setVisible(false);
        txtCodigo.setVisible(false);
        escolha_Panel.setVisible(true);
        login_Panel.setVisible(false);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        codigo_label = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        voltar_btn = new javax.swing.JButton();
        escolha_Panel = new javax.swing.JPanel();
        cliente_btn = new javax.swing.JButton();
        adm_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Login");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/filme.png"))); // NOI18N

        login_Panel.setBackground(new java.awt.Color(255, 255, 255));
        login_Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        login_Panel.setForeground(new java.awt.Color(255, 255, 255));
        login_Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 141, 255));
        jLabel1.setText("Login");

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(66, 141, 255));
        jLabel3.setText("Senha");

        btnEntrar.setBackground(new java.awt.Color(33, 150, 243));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setForeground(new java.awt.Color(51, 51, 51));

        btnCadastrar.setForeground(new java.awt.Color(51, 102, 255));
        btnCadastrar.setText("Não tem conta? Registre-se");
        btnCadastrar.setBorder(null);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cinema.png"))); // NOI18N

        codigo_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codigo_label.setForeground(new java.awt.Color(66, 141, 255));
        codigo_label.setText("Código");

        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(51, 51, 51));

        voltar_btn.setForeground(new java.awt.Color(51, 102, 255));
        voltar_btn.setText("<< Voltar");
        voltar_btn.setBorder(null);
        voltar_btn.setContentAreaFilled(false);
        voltar_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        voltar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout login_PanelLayout = new javax.swing.GroupLayout(login_Panel);
        login_Panel.setLayout(login_PanelLayout);
        login_PanelLayout.setHorizontalGroup(
            login_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_PanelLayout.createSequentialGroup()
                .addGroup(login_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(login_PanelLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2))
                    .addGroup(login_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(login_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(login_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltar_btn))
                    .addGroup(login_PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(login_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(codigo_label)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(login_PanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(login_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCadastrar)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(312, 312, 312))
        );
        login_PanelLayout.setVerticalGroup(
            login_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_PanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(codigo_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar)
                .addGap(14, 14, 14)
                .addComponent(voltar_btn)
                .addContainerGap())
        );

        escolha_Panel.setBackground(new java.awt.Color(255, 255, 255));
        escolha_Panel.setForeground(new java.awt.Color(255, 255, 255));

        cliente_btn.setBackground(new java.awt.Color(33, 150, 243));
        cliente_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cliente_btn.setForeground(new java.awt.Color(255, 255, 255));
        cliente_btn.setText("Cliente");
        cliente_btn.setBorderPainted(false);
        cliente_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cliente_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_btnActionPerformed(evt);
            }
        });

        adm_btn.setBackground(new java.awt.Color(33, 150, 243));
        adm_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        adm_btn.setForeground(new java.awt.Color(255, 255, 255));
        adm_btn.setText("Administrador");
        adm_btn.setBorderPainted(false);
        adm_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        adm_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adm_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Escolha um tipo de usuário");

        javax.swing.GroupLayout escolha_PanelLayout = new javax.swing.GroupLayout(escolha_Panel);
        escolha_Panel.setLayout(escolha_PanelLayout);
        escolha_PanelLayout.setHorizontalGroup(
            escolha_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolha_PanelLayout.createSequentialGroup()
                .addGroup(escolha_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escolha_PanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escolha_PanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(cliente_btn)
                        .addGap(18, 18, 18)
                        .addComponent(adm_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escolha_PanelLayout.setVerticalGroup(
            escolha_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escolha_PanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(escolha_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente_btn)
                    .addComponent(adm_btn))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(escolha_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(escolha_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void adminConfig() {
        codigo_label.setVisible(true);
        txtCodigo.setVisible(true);
        login_Panel.setVisible(true);
        escolha_Panel.setVisible(false);
        this.pack();
    }
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario();
        this.desktopPane.removeAll();
        this.desktopPane.add(telaCadastro);
        telaCadastro.setVisible(true);
        this.pack();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        UsuarioController usuarioController = new UsuarioController();
        int codigo = 0;
        if (!txtCodigo.getText().isEmpty()) {
            try {
                codigo = Integer.parseInt(txtCodigo.getText());
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "O código deve ser um número.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Tenta fazer o login
        Usuario usuario = usuarioController.login(txtUsername.getText(), txtSenha.getPassword(), codigo);
        if (usuario != null) {
            this.parentFrame.onLoginSuccess(usuario); 
            this.dispose();
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void cliente_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_btnActionPerformed
        login_Panel.setVisible(true);
        escolha_Panel.setVisible(false);
        codigo_label.setVisible(false);
        txtCodigo.setVisible(false);
        this.pack();
    }//GEN-LAST:event_cliente_btnActionPerformed

    private void adm_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adm_btnActionPerformed
        adminConfig();
    }//GEN-LAST:event_adm_btnActionPerformed

    private void voltar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar_btnActionPerformed
        codigo_label.setVisible(false);
        txtCodigo.setVisible(false);
        login_Panel.setVisible(false);
        escolha_Panel.setVisible(true);
        this.pack();
    }//GEN-LAST:event_voltar_btnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adm_btn;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton cliente_btn;
    private javax.swing.JLabel codigo_label;
    private javax.swing.JPanel escolha_Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel login_Panel;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JButton voltar_btn;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JDesktopPane desktopPane;
}
