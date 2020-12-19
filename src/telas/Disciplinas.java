/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.sql.*;
import conector.BDConect;
import javax.swing.*;

/**
 *
 * @author albert
 */
public class Disciplinas extends javax.swing.JFrame {
    
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private String aulasem; //radio button das aulas

    /**
     * Creates new form Disciplinas
     */
    public Disciplinas() {
        initComponents();
        conex=BDConect.conector();
    }
    
    private void pesquisar_disci(){
        String id = TCD.getText();
        String sql = "select * from disciplinas where cod_disc =" + id;
        try {
            ps = conex.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                TCD.setText(rs.getString(1));//1 no bd
                TCC.setText(rs.getString(2));
                TIP.setText(rs.getString(3));
                TND.setText(rs.getString(4));
                TCH.setText(rs.getString(5));
                String rbtCH = rs.getString(6);
                if ("1".equals(rbtCH)) {
                    rb1.setSelected(true);
                    aulasem = "1";
                } else if("2".equals(rbtCH)) {
                    rb2.setSelected(true);
                    aulasem = "2";
                }else if("3".equals(rbtCH)) {
                    rb3.setSelected(true);
                    aulasem = "3";
                }else if("4".equals(rbtCH)) {
                    rb4.setSelected(true);
                    aulasem = "4";
                }else if("5".equals(rbtCH)) {
                    rb5.setSelected(true);
                    aulasem = "5";
                }else if("6".equals(rbtCH)) {
                    rb6.setSelected(true);
                    aulasem = "6";
                }
                btnInclusao.setEnabled(false);
                
            }else {
                JOptionPane.showMessageDialog(null, "Disciplina não cadastrada");
                TCD.setText(null);//1 no bd
                TND.setText(null);
                TCH.setText(null);
                TIP.setText(null);
                TCC.setText(null);
                btnInclusao.setEnabled(true);
            }
            
        }catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Disciplina invalida");
                TCD.setText(null);
                TND.setText(null);
                TCH.setText(null);
                TIP.setText(null);
                TCC.setText(null);
                btnInclusao.setEnabled(true);
        }catch (Exception e2) {
             JOptionPane.showMessageDialog(null, e2);
        }
    }
    private void alterar(){
        String sql = "update disciplinas set cod_curso=?, iden_prof=?, nome_disc=?,carga_horaria=?,aulas_semana=? where cod_disc=?";
        try {
            ps=conex.prepareStatement(sql);
            //numero correspon. aos ? da String sql           
            ps.setString(1,TCC.getText());
            ps.setString(2,TIP.getText());
            ps.setString(3,TND.getText());
            ps.setString(4,TCH.getText());
            ps.setString(5,aulasem);
            ps.setString(6,TCD.getText());
            if((TCD.getText().isEmpty())||(TCC.getText().isEmpty())||(TIP.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int adicionado = ps.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Disciplina alterada com sucesso");
                TCD.setText(null);
                TND.setText(null);
                TCH.setText(null);
                TIP.setText(null);
                TCC.setText(null);
                btnInclusao.setEnabled(true);
                
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu");
        }
    }
    
    private void incluir(){
        String sql = "Insert into disciplinas values (?,?,?,?,?,?)";
        try {
            ps = conex.prepareStatement(sql);
            ps.setString(1,TCD.getText());
            ps.setString(2,TCC.getText());
            ps.setString(3,TIP.getText());
            ps.setString(4,TND.getText());
            ps.setString(5,TCH.getText());
            ps.setString(6,aulasem);
             if((TCD.getText().isEmpty())||(TCC.getText().isEmpty())||(TIP.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int adicionado = ps.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Disciplina criada com sucesso");
                TCD.setText(null);
                TND.setText(null);
                TCH.setText(null);
                TIP.setText(null);
                TCC.setText(null);
                
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu");
        }
    }
    private void excluir(){
         int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa Disciplina?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma==JOptionPane.YES_OPTION) {
            String sql = "delete from disciplinas where cod_disc=?";
            try {
                ps=conex.prepareStatement(sql);
                ps.setString(1,TCD.getText());
                int apagado = ps.executeUpdate();
                if (apagado>0) {
                    JOptionPane.showMessageDialog(null, "Disciplina excluida com sucesso");
                TCD.setText(null);
                TND.setText(null);
                TCH.setText(null);
                TIP.setText(null);
                TCC.setText(null);
                btnInclusao.setEnabled(true);
                }
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    }
            }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TCD = new javax.swing.JTextField();
        TND = new javax.swing.JTextField();
        TCH = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        btnInclusao = new javax.swing.JButton();
        btnAlteracao = new javax.swing.JButton();
        btnExclusao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnPesquisar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TCC = new javax.swing.JTextField();
        TIP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Disciplinas");

        jLabel1.setText("CodDisc*:");

        jLabel2.setText("NomeDisci:");

        jLabel3.setText("CargaHorária:");

        TND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNDActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Aula Semana"));
        jPanel1.setName("Aulas Semana"); // NOI18N

        buttonGroup1.add(rb1);
        rb1.setText("1");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb2);
        rb2.setText("2");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb3);
        rb3.setText("3");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb4);
        rb4.setText("4");
        rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb6);
        rb6.setText("6");
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb5);
        rb5.setText("5");
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(rb6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rb4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rb5))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb1)
                    .addComponent(rb4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb2)
                    .addComponent(rb5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb3)
                    .addComponent(rb6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInclusao.setText("inclusão");
        btnInclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInclusaoActionPerformed(evt);
            }
        });

        btnAlteracao.setText("alteração");
        btnAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteracaoActionPerformed(evt);
            }
        });

        btnExclusao.setText("exclusão");
        btnExclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExclusaoActionPerformed(evt);
            }
        });

        jLabel4.setText("<-");

        BtnPesquisar.setText("Pesquisar");
        BtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisarActionPerformed(evt);
            }
        });

        jLabel5.setText("CodCurso*:");

        jLabel6.setText("IdenProf*:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnInclusao)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlteracao)
                        .addGap(18, 18, 18)
                        .addComponent(btnExclusao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TCH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TND))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(TCD, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TIP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnPesquisar)))
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(BtnPesquisar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInclusao)
                    .addComponent(btnAlteracao)
                    .addComponent(btnExclusao))
                .addGap(24, 24, 24))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Aulas Semana");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
aulasem = "2";
// TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

    private void TNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNDActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        pesquisar_disci();
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        aulasem = "1";
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        aulasem = "3";
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4ActionPerformed
        aulasem = "4";
// TODO add your handling code here:
    }//GEN-LAST:event_rb4ActionPerformed

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
        aulasem = "5";
    }//GEN-LAST:event_rb5ActionPerformed

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
        aulasem = "6";
    }//GEN-LAST:event_rb6ActionPerformed

    private void btnAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteracaoActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlteracaoActionPerformed

    private void btnInclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInclusaoActionPerformed
        incluir();
    }//GEN-LAST:event_btnInclusaoActionPerformed

    private void btnExclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExclusaoActionPerformed
        excluir();
    }//GEN-LAST:event_btnExclusaoActionPerformed

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
            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Disciplinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Disciplinas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JTextField TCC;
    private javax.swing.JTextField TCD;
    private javax.swing.JTextField TCH;
    private javax.swing.JTextField TIP;
    private javax.swing.JTextField TND;
    private javax.swing.JButton btnAlteracao;
    private javax.swing.JButton btnExclusao;
    private javax.swing.JButton btnInclusao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JRadioButton rb6;
    // End of variables declaration//GEN-END:variables
}
