/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.view;

import br.com.fatec.controller.GerenciarVisitaController;
import br.com.fatec.model.Visitante;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author aluno
 */
public class CadastroVisitante extends javax.swing.JFrame {

    private GerenciarVisitaController ger = new GerenciarVisitaController();
    
    /**
     * Creates new form GerenciarVisita
     */
    public CadastroVisitante() {
        initComponents();
        lbDocE.setVisible(false);
        txtDocE.setVisible(false);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        ckEstudante = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbDocE = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtTel = new javax.swing.JFormattedTextField();
        txtDocE = new javax.swing.JFormattedTextField();
        btNovo = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        txtBusca = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Buscar por CPF:");

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados cadastrais"));
        jPanel2.setToolTipText("");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        ckEstudante.setText("Estudante");
        ckEstudante.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ckEstudanteStateChanged(evt);
            }
        });

        jLabel4.setText("E-mail");

        jLabel5.setText("Telefone:");

        lbDocE.setText("Nº Doc:");

        try {
            txtCpf.setFormatterFactory(new DefaultFormatterFactory(
                new MaskFormatter("###.###.###-##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    try {
        txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    txtDocE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addComponent(jLabel4)
                .addComponent(jLabel3))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtNome)
                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addComponent(txtCpf))
            .addGap(34, 34, 34)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ckEstudante)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(lbDocE, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtTel)
                        .addComponent(txtDocE))))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(ckEstudante)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbDocE)
                .addComponent(txtDocE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5)
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    btNovo.setText("Limpar");
    btNovo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btNovoActionPerformed(evt);
        }
    });

    btCadastrar.setText("Cadastrar");
    btCadastrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btCadastrarActionPerformed(evt);
        }
    });

    btAlterar.setText("Alterar");
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btAlterarActionPerformed(evt);
        }
    });

    btExcluir.setText("Excluir");
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btExcluirActionPerformed(evt);
        }
    });

    try {
        txtBusca.setFormatterFactory(new DefaultFormatterFactory(
            new MaskFormatter("###.###.###-##")));
    } catch (java.text.ParseException ex) {
        ex.printStackTrace();
    }

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btBuscar)
                            .addGap(0, 68, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(btNovo)
                    .addGap(31, 31, 31)
                    .addComponent(btCadastrar)
                    .addGap(42, 42, 42)
                    .addComponent(btAlterar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir)
                    .addGap(20, 20, 20))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(btBuscar)
                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btNovo)
                .addComponent(btCadastrar)
                .addComponent(btAlterar)
                .addComponent(btExcluir))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckEstudanteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ckEstudanteStateChanged
        // TODO add your handling code here:
        if(ckEstudante.isSelected()){
            lbDocE.setVisible(true);
            txtDocE.setVisible(true);
        }else{
            lbDocE.setVisible(false);
            txtDocE.setVisible(false);
        }    
    }//GEN-LAST:event_ckEstudanteStateChanged
    
    private void limparCampos(){
        txtBusca.setText("");
        txtCpf.setText("");
        txtDocE.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtTel.setText("");
        txtCpf.setEnabled(true);
        ckEstudante.setSelected(false);
        btCadastrar.setEnabled(true);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }
    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        if(txtBusca.getText().equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(this, "Preecha o campo de busca", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                List<String> dados = ger.retornarVisitante(txtBusca.getText());
                txtCpf.setText(dados.get(0));
                txtEmail.setText(dados.get(1));
                txtNome.setText(dados.get(2));
                txtTel.setText(dados.get(3));
                
                if(dados.size()==5){
                    txtDocE.setText(dados.get(4));
                    ckEstudante.setSelected(true);
                    txtDocE.setVisible(true);
                }
                
                txtCpf.setEnabled(false);
                btCadastrar.setEnabled(false);
                btAlterar.setEnabled(true);
                btExcluir.setEnabled(true);
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(this, "Visitante não encontrado!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro : " + ex.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        // TODO add your handling code here:
        if(txtCpf.getText().equals("   .   .   -  ") || txtEmail.getText().equals("") || txtNome.getText().equals("")
                || txtTel.getText().equals("(  )     -    ")){
            JOptionPane.showMessageDialog(this, "Preecha todos os campos", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                ger.registrarVisitante(txtNome.getText(), txtEmail.getText(), 
                        txtCpf.getText(), txtTel.getText(), ckEstudante.isSelected(), txtDocE.getText());
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro : " + ex.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        if(txtCpf.getText().equals("   .   .   -  ") || txtNome.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Preecha o nome", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                ger.atualizarVisitante(txtNome.getText(), txtEmail.getText(), 
                        txtCpf.getText(), txtTel.getText(), ckEstudante.isSelected(), txtDocE.getText());
                JOptionPane.showMessageDialog(this, "Atualizado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(this, "Visitante não encontrado!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro : " + ex.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int opc = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse registro?", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        if(opc==JOptionPane.YES_OPTION){
            try {
                Visitante visit = ger.consultarVisitante(txtCpf.getText());
                ger.excluirVisitante(visit);
                JOptionPane.showMessageDialog(this, "Removido com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(this, "Visitante não encontrado!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro : " + ex.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }//GEN-LAST:event_btExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVisitante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JCheckBox ckEstudante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbDocE;
    private javax.swing.JFormattedTextField txtBusca;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDocE;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTel;
    // End of variables declaration//GEN-END:variables
}