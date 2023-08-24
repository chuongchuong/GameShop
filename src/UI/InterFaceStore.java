/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.NapTheDAO;
import DAO.StoreDAO;
import DAO.ThongKePhanHoiDAO;
import DAO.UserDAO;
import Packet.NapTheDATA;
import Packet.StoreUserData;
import Packet.ThongKePHDaTa;
import Packet.UserLib;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoang Minh
 */
public class InterFaceStore extends javax.swing.JFrame {

    StoreDAO dao = new StoreDAO();
    UserDAO dao2 = new UserDAO();
    ThongKePhanHoiDAO dao3 = new ThongKePhanHoiDAO();
    NapTheDAO dao4 = new NapTheDAO();
    String duongdananh="";
    String duongdananhMain="";
    ArrayList<StoreUserData> listed =new  ArrayList<>();
    int index1=0;
    Connection cnn = null;
    
    Statement st = null;
    String sql = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public static InterFaceStore store;
    public JLabel lbl3;
    public JLabel lbl4;
    
    public InterFaceStore() {
        
        loadDataList();
        
        initComponents();
        init();
        
    }
    public boolean chkPrice(){
        float price = Float.parseFloat(lblPrice.getText());
        float money = Float.parseFloat(lbldisplaymoney.getText());
        if(price > money){
            JOptionPane.showMessageDialog(this, "Bạn không đủ tiền mua game!!!");
            return false;
        }
        return true;
    }
public void init(){
        store = this;
        lbl3 = lbldisplaymoney;
        lbl4=lblNguoiDung;
        fillComboBox();
        LoadDataToTable();
        lblMainID.setVisible(false);
        showRecord1(0,1,2);
        System.out.println(index1);
        DefaultTableModel model = new DefaultTableModel();
        tblMenu.removeColumn(tblMenu.getColumn("Pic"));
        tblMenu.removeColumn(tblMenu.getColumn("ID"));
        tblMenu.removeColumn(tblMenu.getColumn("Thông Tin"));
        tblMenu.removeColumn(tblMenu.getColumn("NPH"));
       int indexxx =0;
       tblMenu.setRowSelectionInterval(indexxx, indexxx);
        this.setLocationRelativeTo(null);
    }
public void loadDataList(){

         try{
             cnn = DAO.DaoLib1.connToSQL("sa", "songlong", 1433, "QuanLyGame");
    String sql =("select * from StoreUser_Lib");
             st = cnn.createStatement();
            rs = st.executeQuery(sql);
            listed.clear();
             listed.clear();
         while (rs.next()) {
                    String ma = rs.getString("IDGame");
                    String ten = rs.getString("Game");
                    float ta = rs.getFloat("GiaGame");
                    String nph = rs.getString("NPH");
                    String theloai = rs.getString("TheLoai");
                    String gamepic = rs.getString("GamePic");
                    String thongtin = rs.getString("ThongTin");
                    StoreUserData gr = new StoreUserData(ma,ten,nph,ta,theloai,gamepic,thongtin);
                    listed.add(gr);
                }
         st.close();
            rs.close();
         }catch(Exception e){
             
         }
}
public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(Pic1.getWidth(), Pic1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    public void showRecord1(int k, int i, int j) {
        try{
        DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
        if (k >= 0 && i>0 && j>0 ) {
            
            lplT1.setText((String) model.getValueAt(k, 0));
            duongdananh=(String) model.getValueAt(k,5);
            Pic1.setIcon(ResizeImage(String.valueOf("src\\img\\"+duongdananh)));
            
            lplT2.setText((String) model.getValueAt(i, 0));
            duongdananh=(String) model.getValueAt(i,5);
            lblP2.setIcon(ResizeImage(String.valueOf("src\\img\\"+duongdananh)));
            
            lplT3.setText((String) model.getValueAt(j, 0));
            duongdananh=(String) model.getValueAt(j,5);
            lblP3.setIcon(ResizeImage(String.valueOf("src\\img\\"+duongdananh)));
        }
        }catch(Exception e){
            
    }
        }
    public void LoadDataToTable(){
       try{
        DefaultTableModel mode = (DefaultTableModel) tblMenu.getModel();
        mode.setRowCount(0);
        
        List<StoreUserData> list = this.dao.selectAll();
        if(list ==  null){
           
            return;
        }
        for (StoreUserData pro : list) {
            Object[] row = new Object[]{pro.getGame() , pro.getTheLoai() ,
            pro.getPrice(),pro.getNPH(),pro.getThongTin(),pro.getGamePic(),pro.getIDGame()};
            mode.addRow(row);
        }}catch(Exception e){
            System.out.println("Không có dữ liệu");
        }
    }
    private void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
        model.setRowCount(0);
        StoreUserData pros = (StoreUserData) cboMenu.getSelectedItem();
        List<StoreUserData> list = dao.display_by_type(pros.getTheLoai());
        if(list ==  null){
            JOptionPane.showMessageDialog(this,"Lỗi");
            return;
        }for (StoreUserData pro : list) {
            Object[] row = new Object[]{pro.getGame() , pro.getTheLoai() ,
            pro.getPrice(),pro.getNPH(),pro.getThongTin(),pro.getGamePic(),pro.getIDGame()};
            model.addRow(row);
        }   
    }
    public void fillFindTable() {
        try{
       DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
        model.setRowCount(0);

        try {
            String keyword = this.txtFindGame.getText();
            List<StoreUserData> list = this.dao.selectByKeyword(keyword);
            Iterator var4 = list.iterator();

            while (var4.hasNext()) {
                StoreUserData pro = (StoreUserData) var4.next();
                Object[] row = new Object[]{pro.getGame() , pro.getTheLoai() ,
            pro.getPrice(),pro.getNPH(),pro.getThongTin(),pro.getGamePic(),pro.getIDGame()};
            model.addRow(row);
            }
        } catch (Exception var7) {
            System.out.println("Fail");
        }
        }catch(Exception e){
            
        }
    }
    public void showRecord(int k) {
        DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
        if (k >= 0) {

            lblName.setText((String) model.getValueAt(k, 0));
            lblType.setText((String) model.getValueAt(k, 1));
            lblPrice.setText( model.getValueAt(k, 2).toString());
            lblNPH.setText((String) model.getValueAt(k, 3));
            
            txtInfo.setText((String) model.getValueAt(k, 4));
            if(!model.getValueAt(k, 5).toString().equals("")){
                lblMainPic.setText("");
            }
            lblMainID.setText((String) model.getValueAt(k, 6));
            duongdananhMain=(String) model.getValueAt(k,5);
            lblMainPic.setIcon(ResizeImage(String.valueOf("src\\img\\"+duongdananhMain)));
            
            
        }

    }
private void fillComboBox() {
    DefaultComboBoxModel mode = (DefaultComboBoxModel) cboMenu.getModel();
    mode.removeAllElements();
    List<StoreUserData> list = dao.SelectByType_combobox();
    for (StoreUserData pro : list) {
        mode.addElement(pro);
    }
}
    public UserLib getForm(){
        String id = lblMainID.getText();
        
        String name = lblName.getText();
        float price = 0;
        try {
             price = Float.valueOf(lblPrice.getText());
        } catch (Exception e) {
            return null;
        }
        
        String type = lblType.getText();
        String nph =lblNPH.getText();
        String info =txtInfo.getText();
        
        return new UserLib(id , name,nph , price , type,duongdananhMain,info);
    }
   
    public NapTheDATA getFormBuy(){
        String user= lblNguoiDung.getText();
        float money = 0;
        
        try {
             money= Float.valueOf(lblPrice.getText());
        } catch (Exception e) {
            return null;
        }
        return new NapTheDATA(user,money);
    }
            
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboMenu = new javax.swing.JComboBox<>();
        txtFindGame = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        lplT1 = new javax.swing.JLabel();
        lplT2 = new javax.swing.JLabel();
        lplT3 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        Pic1 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblType = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMainPic = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblMainID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNPH = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        lblNguoiDung = new javax.swing.JLabel();
        lbldisplaymoney = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Thể Loại");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        cboMenu.setForeground(new java.awt.Color(0, 51, 255));
        cboMenu.setToolTipText("");
        cboMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMenuActionPerformed(evt);
            }
        });
        jPanel1.add(cboMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 250, 30));

        txtFindGame.setForeground(new java.awt.Color(0, 51, 255));
        txtFindGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindGameActionPerformed(evt);
            }
        });
        jPanel1.add(txtFindGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 180, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Find Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, 30));

        jScrollPane1.setForeground(new java.awt.Color(0, 51, 255));

        tblMenu.setForeground(new java.awt.Color(0, 0, 153));
        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Games", "Thể Loại", "Giá Game", "NPH", "Thông Tin", "Pic", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMenu);
        if (tblMenu.getColumnModel().getColumnCount() > 0) {
            tblMenu.getColumnModel().getColumn(0).setResizable(false);
            tblMenu.getColumnModel().getColumn(1).setResizable(false);
            tblMenu.getColumnModel().getColumn(2).setResizable(false);
            tblMenu.getColumnModel().getColumn(3).setResizable(false);
            tblMenu.getColumnModel().getColumn(4).setResizable(false);
            tblMenu.getColumnModel().getColumn(5).setResizable(false);
            tblMenu.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 720, 200));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("TOP 3 GAME");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        lblP2.setForeground(new java.awt.Color(0, 51, 255));
        lblP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP2.setText("Pic2");
        lblP2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jPanel1.add(lblP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 147, 130));

        lplT1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lplT1.setForeground(new java.awt.Color(0, 51, 255));
        lplT1.setText("Name1");
        jPanel1.add(lplT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 52, 23));

        lplT2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lplT2.setForeground(new java.awt.Color(0, 51, 255));
        lplT2.setText("Name2");
        jPanel1.add(lplT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, -1, -1));

        lplT3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lplT3.setForeground(new java.awt.Color(0, 51, 255));
        lplT3.setText("Name3");
        jPanel1.add(lplT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, -1, -1));

        lblP3.setForeground(new java.awt.Color(0, 51, 255));
        lblP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblP3.setText("Pic3");
        lblP3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jPanel1.add(lblP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 147, 130));

        Pic1.setForeground(new java.awt.Color(0, 51, 255));
        Pic1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Pic1.setText("Pic1");
        Pic1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        jPanel1.add(Pic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 154, 130));

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNext.setText("NEXT");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel1.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, 90, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("PREV");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 80, 30));

        jButton3.setText("NẠP TIỀN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("Featured & Recommended");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 250, -1));

        jTabbedPane1.addTab("Store", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblType.setText("......");
        jPanel2.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Giá Game");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        lblMainPic.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMainPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainPic.setText("Game Pic");
        lblMainPic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(lblMainPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 204, 170));

        lblPrice.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPrice.setText(".....");
        jPanel2.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 110, -1));

        btnAdd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdd.setText("Mua Game");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 128, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Thể loại");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 70, -1));

        lblMainID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMainID.setText("HIDDENID");
        jPanel2.add(lblMainID, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Nhà phát hành");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 110, -1));

        lblNPH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNPH.setText("......");
        jPanel2.add(lblNPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 170, -1));

        jScrollPane2.setForeground(new java.awt.Color(255, 204, 0));

        txtInfo.setColumns(20);
        txtInfo.setRows(5);
        txtInfo.setEnabled(false);
        jScrollPane2.setViewportView(txtInfo);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 650, 120));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Thông Tin");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        lblNguoiDung.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNguoiDung.setText("NGUOIDUNG");
        jPanel2.add(lblNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        lbldisplaymoney.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbldisplaymoney.setText(".......");
        jPanel2.add(lbldisplaymoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 80, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Số dư tài khoản:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        lblName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 51, 255));
        lblName.setText("Tên Game");
        jPanel2.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 204, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 102, 255));
        jLabel11.setText("Đến thư viện");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.addTab("Info", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String p = lblPrice.getText();
        int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn mua game này với giá "+ p + "$$$");
        if(res == JOptionPane.YES_OPTION){
        if(chkPrice()){
        try{
        UserLib pro = getForm();
        NapTheDATA ins = getFormBuy();
        if(pro != null){
            dao2.insert(getForm());
           dao4.update2(getFormBuy());
            JOptionPane.showMessageDialog(this, "Thành công");

        }else{
            System.out.println("Fail");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Bạn đã sở hữu game này rồi");
        }
    }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cboMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMenuActionPerformed

        fillTable();
    }//GEN-LAST:event_cboMenuActionPerformed

    private void txtFindGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillFindTable();
        showRecord1(0,1,2);
    }//GEN-LAST:event_jButton1ActionPerformed
int row =-1;
    private void tblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMenuMouseClicked
        int indextt = tblMenu.getSelectedRow();
        showRecord(indextt);
        if(evt.getClickCount() == 2){
            this.row = tblMenu.getSelectedRow();
            jTabbedPane1.setSelectedIndex(1);
            
        }
    }//GEN-LAST:event_tblMenuMouseClicked

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       
        if(listed.size()!=0){
        if (index1 == listed.size() - 1) {
            index1 = 0;
            showRecord1(2+index1,3+index1,4+index1);
            tblMenu.setRowSelectionInterval(index1, index1);
        } else {
            index1++;
            showRecord1(2+index1,3+index1,4+index1);
            //tblMenu.setRowSelectionInterval(index, index);
        }
        }else{
            JOptionPane.showMessageDialog(this, "Danh sách chưa có người dùng");
        }
      
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(listed.size()!=0){
        if (index1 == listed.size() - 1) {
            index1 = 0;
            showRecord1(2+index1,3+index1,4+index1);
            tblMenu.setRowSelectionInterval(index1, index1);
        } else {
            index1--;
            showRecord1(2+index1,3+index1,4+index1);
            //tblMenu.setRowSelectionInterval(index, index);
        }
        }else{
            JOptionPane.showMessageDialog(this, "Danh sách chưa có người dùng");
        }    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NapTien npt = new NapTien();
        npt.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        openthuvien();
    }//GEN-LAST:event_jLabel11MouseClicked
     public void openthuvien(){
        Library u = new Library();
                u.setVisible(true);
                this.dispose();
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
            java.util.logging.Logger.getLogger(InterFaceStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterFaceStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterFaceStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterFaceStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterFaceStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pic1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNext;
    private javax.swing.JComboBox<String> cboMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMainID;
    private javax.swing.JLabel lblMainPic;
    private javax.swing.JLabel lblNPH;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNguoiDung;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lbldisplaymoney;
    private javax.swing.JLabel lplT1;
    private javax.swing.JLabel lplT2;
    private javax.swing.JLabel lplT3;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTextField txtFindGame;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
