/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.AdminDAO;
import DAO.StoreDAO;
import Packet.StoreAdminData;
import Packet.StoreUserData;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoang Minh
 */
public class Admin extends javax.swing.JFrame {
    
    AdminDAO dao = new AdminDAO() ;
    StoreDAO dao2 = new StoreDAO();
    
    
    String duongdananh="";
  
    Connection cnn = null;
    int index = -1;
    PreparedStatement sttm = null;
    int current = 0;
    
    public Admin() {
        initComponents();
        init();
        
        lblPic.setBorder(new LineBorder(Color.BLACK, 3));
        this.setLocationRelativeTo(null);
    }
    private void init(){
        LoadDataToTable();
    }
    public StoreAdminData getForm(){
        String id = txtID.getText();
        
        String name = txtName.getText();
        float price = 0;
        try {
             price = Float.valueOf(txtPrice.getText());
        } catch (Exception e) {
            return null;
        }
        
        String type = txtType.getText();
        String nph =txtNPH.getText();
        String info =txtInfo.getText();
        
        return new StoreAdminData(id , name,nph , price , type,duongdananh,info);
    }
    public StoreUserData getForm2(){
        String id = txtID.getText();
        
        String name = txtName.getText();
        float price = 0;
        try {
             price = Float.valueOf(txtPrice.getText());
        } catch (Exception e) {
            return null;
        }
        
        String type = txtType.getText();
        String nph =txtNPH.getText();
        String info =txtInfo.getText();
        
        return new StoreUserData(id , name,nph , price , type,duongdananh,info);
    }
    public void LoadDataToTable(){
    try{
        DefaultTableModel mode = (DefaultTableModel) tblAdmin.getModel();
        mode.setRowCount(0);
        
        List<StoreAdminData> list = this.dao.selectAll();
        if(list ==  null){
           
            return;
        }
        for (StoreAdminData pro : list) {
            Object[] row = new Object[]{pro.getGame() , pro.getTheLoai() ,
            pro.getGiaGame(),pro.getNPH(),pro.getGamePic(),pro.getGID(),pro.getThongTin()};
            mode.addRow(row);
        }}catch(Exception e){
            System.out.println("Không có dữ liệu");
        }
    }
    public Boolean Val(){
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu mã seri game");
            return false;
        }
        if (txtID.getText().length() > 20) {
            JOptionPane.showMessageDialog(this, "Mã seri không được chứa quá 20 ký tự");
            return false;
        }
        if (txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu tên game");
            return false;
        }
        if (txtType.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Game thuộc thể loại nào?");
            return false;
        }
        if (txtPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu giá game");
            return false;
        }
        try{
            float price = Float.parseFloat(txtPrice.getText());
            if(price<0){
                JOptionPane.showMessageDialog(this, "Giá game không dc âm");
                return false;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Giá game sai định dạng");
        }
        if (txtNPH.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu nhà phát hành game");
            return false;
        }
        if (txtType.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu thông tin game");
            return false;
        }
        
        
        return true;
    }
   
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblPic.getWidth(), lblPic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
        jPanel2 = new javax.swing.JPanel();
        txtTK = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        lblPic = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        txtNPH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnDel = new javax.swing.JButton();
        btnFix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        txtTK.setPreferredSize(new java.awt.Dimension(6, 31));
        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tìm Game");

        btnTim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTim.setText("Tìm Kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 11, -1, -1));

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Games", "Thể Loại", "Giá Game", "NPH", "GamePic", "GID", "Thông Tin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);
        if (tblAdmin.getColumnModel().getColumnCount() > 0) {
            tblAdmin.getColumnModel().getColumn(0).setResizable(false);
            tblAdmin.getColumnModel().getColumn(1).setResizable(false);
            tblAdmin.getColumnModel().getColumn(2).setResizable(false);
            tblAdmin.getColumnModel().getColumn(3).setResizable(false);
            tblAdmin.getColumnModel().getColumn(4).setResizable(false);
            tblAdmin.getColumnModel().getColumn(5).setResizable(false);
            tblAdmin.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 400, 537, 160));

        btnAdd.setBackground(new java.awt.Color(204, 204, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Thêm Game");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 124, 35));

        lblPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPic.setText("GamePic");
        lblPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPicMouseClicked(evt);
            }
        });
        jPanel1.add(lblPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 239, 198));

        txtType.setPreferredSize(new java.awt.Dimension(6, 31));
        txtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeActionPerformed(evt);
            }
        });
        jPanel1.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 186, 280, -1));

        txtNPH.setPreferredSize(new java.awt.Dimension(6, 31));
        txtNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNPHActionPerformed(evt);
            }
        });
        jPanel1.add(txtNPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 395, 279, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Thể Loại");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 191, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NPH");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Thông Tin");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 452, -1, -1));

        txtID.setPreferredSize(new java.awt.Dimension(6, 31));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 244, 280, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("GID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 258, -1, -1));

        txtPrice.setPreferredSize(new java.awt.Dimension(6, 31));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 305, 278, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Giá Game");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 310, -1, -1));

        txtName.setPreferredSize(new java.awt.Dimension(6, 31));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 128, 280, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tên Game");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 133, -1, -1));

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        jScrollPane2.setViewportView(txtInfo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 452, 279, 65));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 102, 255));
        jLabel6.setText("Quay lại trang chủ");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, -1, -1));

        btnDel.setBackground(new java.awt.Color(204, 204, 255));
        btnDel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDel.setText("Xóa Game");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 124, 35));

        btnFix.setBackground(new java.awt.Color(204, 204, 255));
        btnFix.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFix.setText("Sửa Thông Tin");
        btnFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFixActionPerformed(evt);
            }
        });
        jPanel1.add(btnFix, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 140, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Vì số lượng tên game có thể trùng nhau nên bạn chỉ có thể tìm"
            + " bằng mã game GID");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        fillFindTable();
    }//GEN-LAST:event_btnTimActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKActionPerformed

    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        index = tblAdmin.getSelectedRow();
        showRecord(index);
        //show dòng index lên form

    }//GEN-LAST:event_tblAdminMouseClicked

    private void lblPicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPicMouseClicked
        try{
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("E:\\CNTT Fpoly\\JAVA3\\Image"));
            int result = fc.showOpenDialog(this);

            File filenanh = fc.getSelectedFile();
            String fullpath = filenanh.getAbsolutePath();
            duongdananh = fc.getSelectedFile().getName();

            Path src = Paths.get(fullpath);
            Path dest = Paths.get("src\\img\\"+duongdananh);
                lblPic.setIcon(ResizeImage(String.valueOf(dest)));
                Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);

            }catch(Exception e){
                System.out.println("Ban chua chon anh");
                System.out.println(e.toString());
                System.out.println(duongdananh);
            }

    }//GEN-LAST:event_lblPicMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (Val()) {
            StoreAdminData pro = getForm();
            if(pro != null){
                dao.insert(getForm());
                JOptionPane.showMessageDialog(this, "Thành công");

                LoadDataToTable();

            }else{
                System.out.println("Fail");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNPHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNPHActionPerformed

    private void txtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTypeActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFixActionPerformed
        StoreAdminData pro = getForm();
        StoreUserData pro2 = getForm2();
        if(pro != null){
            dao.update(getForm());
            dao2.update(pro2);
            JOptionPane.showMessageDialog(this, "Thành công");

            LoadDataToTable();
        }else{
            System.out.println("Fail");
        }
    }//GEN-LAST:event_btnFixActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       opentrangchu();
    }//GEN-LAST:event_jLabel6MouseClicked
    public void opentrangchu(){
        TrangChuAdmin u = new TrangChuAdmin();
                u.setVisible(true);
        this.dispose();
    }
    public void fillFindTable() {
       DefaultTableModel model = (DefaultTableModel) tblAdmin.getModel();
        model.setRowCount(0);

        try {
            String keyword = this.txtTK.getText();
            List<StoreAdminData> list = this.dao.selectByKeyword(keyword);
            Iterator var4 = list.iterator();

            while (var4.hasNext()) {
                StoreAdminData pro = (StoreAdminData) var4.next();
                Object[] row = new Object[]{pro.getGame() , pro.getTheLoai() ,
            pro.getGiaGame(),pro.getNPH(),pro.getGamePic(),pro.getGID(),pro.getThongTin()};
            
                model.addRow(row);
            }
        } catch (Exception var7) {
            System.out.println("Fail");
        }
    }
    public void showRecord(int k) {
        DefaultTableModel model = (DefaultTableModel) tblAdmin.getModel();
        if (k >= 0) {

            txtName.setText((String) model.getValueAt(k, 0));
            txtType.setText((String) model.getValueAt(k, 1));
            txtPrice.setText( model.getValueAt(k, 2).toString());
            txtNPH.setText((String) model.getValueAt(k, 3));
            txtID.setText((String) model.getValueAt(k, 5));
            txtInfo.setText((String) model.getValueAt(k, 6));
            if(!model.getValueAt(k, 4).toString().equals("")){
                lblPic.setText("");
            }
            
            duongdananh=(String) model.getValueAt(k,4);
            lblPic.setIcon(ResizeImage(String.valueOf("src\\img\\"+duongdananh)));
            
            
        }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnFix;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPic;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtInfo;
    private javax.swing.JTextField txtNPH;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
