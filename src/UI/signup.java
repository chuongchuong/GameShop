/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ME1
 */
public class signup extends javax.swing.JFrame {
            private static final String P_Email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            private static final String P_Pass = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";
            Connection cnn = null ;
            String user = "sa";
            String pass = "songlong"; // thay doi pass cho phu hop
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyGame";
   
    public signup() {
        initComponents();
        txtusername1.setBackground(new java.awt.Color(0,0,0,1));
        txtConfirmPass.setBackground(new java.awt.Color(0,0,0,1));
        txtMail.setBackground(new java.awt.Color(0,0,0,1));
        txtpassword1.setBackground(new java.awt.Color(0,0,0,1));
        this.setLocationRelativeTo(null);
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
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtConfirmPass = new javax.swing.JPasswordField();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        txtpassword1 = new javax.swing.JPasswordField();
        disable2 = new javax.swing.JLabel();
        show2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/GAME.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 470));

        jPanel2.setBackground(new java.awt.Color(25, 118, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sign up");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 420, 41));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 420, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Email");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 341, -1));

        txtMail.setFont(txtMail.getFont().deriveFont(txtMail.getFont().getSize()+2f));
        txtMail.setForeground(new java.awt.Color(255, 255, 255));
        txtMail.setBorder(null);
        txtMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMailActionPerformed(evt);
            }
        });
        jPanel2.add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 40, 39));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(199, 226, 255));
        jLabel8.setText("Confirm Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 341, 20));

        txtConfirmPass.setFont(txtConfirmPass.getFont().deriveFont(txtConfirmPass.getFont().getSize()+2f));
        txtConfirmPass.setForeground(new java.awt.Color(255, 255, 255));
        txtConfirmPass.setBorder(null);
        txtConfirmPass.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 240, 30));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 40, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 40, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(199, 226, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Reset");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 121, 27));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 211));
        jButton1.setText("SIGN UP");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 341, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Login");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 122, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(199, 226, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("You have an account ?");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 213, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(199, 226, 255));
        jLabel10.setText("Username");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 341, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-circled-envelope-20.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(199, 226, 255));
        jLabel17.setText("Password");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 341, 20));

        txtusername1.setFont(txtusername1.getFont().deriveFont(txtusername1.getFont().getSize()+2f));
        txtusername1.setForeground(new java.awt.Color(255, 255, 255));
        txtusername1.setBorder(null);
        txtusername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusername1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtusername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 240, 30));

        txtpassword1.setFont(txtpassword1.getFont().deriveFont(txtpassword1.getFont().getSize()+2f));
        txtpassword1.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword1.setBorder(null);
        txtpassword1.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtpassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 240, 30));

        disable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disable2MouseClicked(evt);
            }
        });
        jPanel2.add(disable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 40, 40));

        show2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show2MouseClicked(evt);
            }
        });
        jPanel2.add(show2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 40, 40));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_____________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 290, 39));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_____________________________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 290, 39));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("_____________________________________");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 290, 39));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("_____________________________________");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 290, 39));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("_____________________________________");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 290, 39));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 470));

        setSize(new java.awt.Dimension(916, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtpassword1.setEchoChar((char)0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtpassword1.setEchoChar((char)8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0; i = i+0.1){
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMailActionPerformed

    private void txtusername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusername1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusername1ActionPerformed

    private void disable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disable2MouseClicked
        txtConfirmPass.setEchoChar((char)0);
        disable2.setVisible(false);
        disable2.setEnabled(false);
        show2.setEnabled(true);
        show2.setEnabled(true);
    }//GEN-LAST:event_disable2MouseClicked

    private void show2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show2MouseClicked
        txtConfirmPass.setEchoChar((char)8226);
        disable2.setVisible(true);
        disable2.setEnabled(true);
        show2.setEnabled(false);
        show2.setEnabled(false);
    }//GEN-LAST:event_show2MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        txtMail.setText("");
        txtConfirmPass.setText("");
        txtpassword1.setText("");
        txtusername1.setText("");
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new login().setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int dk = JOptionPane.showConfirmDialog(this,"Bạn có muốn đăng kí", "Confirm",JOptionPane.YES_NO_OPTION);
//        
//        if (dk!=JOptionPane.YES_NO_OPTION) {
//            return;
//        }
if (validateForm()) {
            
        
        
try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, user, pass);
            String sql = "insert into ACCCOUNT values (?,?,?,?,?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, txtusername1.getText());
            ps.setString(2, txtMail.getText());
            ps.setString(3, txtpassword1.getText());
            ps.setString(4, txtConfirmPass.getText());
            ps.setFloat(5,0);
            int n = ps.executeUpdate();
            //Matcher matcher = Pattern.compile(P_Email).matcher(txtMail.getText());
            if(n!=0){
                JOptionPane.showMessageDialog(this, "Đăng kí thành công");
//            }else if (!matcher.matches()){
//                JOptionPane.showMessageDialog(this, "Sai định dạng email");
          }else{
                JOptionPane.showMessageDialog(this, "Đăng kí thất bại");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
}
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windown".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }
    public boolean validateForm(){
        if (txtusername1.getText().equals("")|txtpassword1.getPassword().equals("")|txtMail.getText().equals("")|txtConfirmPass.getPassword().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            
            return false;
        }
        Matcher matcher = Pattern.compile(P_Email).matcher(txtMail.getText());
        Matcher matcher2 = Pattern.compile(P_Pass).matcher(txtpassword1.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");      
            return false;
        }
        if (!matcher2.matches()) {
            JOptionPane.showMessageDialog(this, "Phải chứa ít nhất một số và một chữ hoa và chữ thường và ít nhất 8 ký tự trở lên");      
            return false;
        }
        
        if (!(txtpassword1.getText().equals(txtConfirmPass.getText()))) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không trùng khớp");
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disable;
    private javax.swing.JLabel disable2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show2;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JTextField txtMail;
    private javax.swing.JPasswordField txtpassword1;
    private javax.swing.JTextField txtusername1;
    // End of variables declaration//GEN-END:variables
}
