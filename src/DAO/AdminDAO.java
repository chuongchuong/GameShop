/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Packet.StoreAdminData;
import Packet.StoreUserData;
import dao.SteamDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Minh
 */
public class AdminDAO extends SteamDAO<StoreAdminData, String>{
    String sql_insert = "insert into StoreAdmin(GID , Game , GiaGame , NPH,TheLoai,GamePic,ThongTin) values (?,?,?,?,?,?,?)";
    String sql_update = "update StoreAdmin set Game = ? , GiaGame = ? , NPH = ?,TheLoai=?,GamePic=?,ThongTin=? where GID = ? ";
    String sql_update2 = "update StoreUser_Lib set Game = ? , GiaGame = ? , NPH = ?,TheLoai=?,GamePic=?,ThongTin=? where IDGame = ? ";
    String sql_all = "select * from StoreAdmin";
    String sql_delete = "delete from StoreAdmin where GID = ?";
    String sql_by_id = "select * from StoreAdmin where GID = ?";
    String sql = "select * from product where type_pro = ?";
    String sql2 = "select distinct type_pro from product";
    
    
    @Override
    public void insert(StoreAdminData bean) {
        XJdbcHelper.update(sql_insert, new Object[]{bean.getGID() , bean.getGame(),bean.getGiaGame(),bean.getNPH(),bean.getTheLoai(),bean.getGamePic(),bean.getThongTin()});
    }
    public void updateStore(StoreUserData bean){
        XJdbcHelper.update(sql_update, new Object[]{   bean.getGame(),bean.getPrice(),bean.getNPH(),bean.getTheLoai(),bean.getGamePic(),bean.getThongTin(),bean.getIDGame()});
    
    }
    @Override
    public void update(StoreAdminData bean) {
        XJdbcHelper.update(sql_update, new Object[]{   bean.getGame(),bean.getGiaGame(),bean.getNPH(),bean.getTheLoai(),bean.getGamePic(),bean.getThongTin(),bean.getGID()});
    }

    @Override
    public void delete(String id) {
        XJdbcHelper.update(sql_delete, new Object[]{id });}

    @Override
    public StoreAdminData selectById(String key) {
        List<StoreAdminData> list = selectBySQL(sql_by_id , new Object[]{key});
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<StoreAdminData> selectAll() {
         List<StoreAdminData> list = selectBySQL(sql_all);
        return list.size() > 0 ? list : null;
    }

    public List<StoreAdminData> selectByKeyword(String keyword) {
      String sql = "SELECT * FROM StoreAdmin WHERE GID LIKE ?";
      return selectBySQL(sql, "%" + keyword + "%");
   }
    @Override
    protected List<StoreAdminData> selectBySQL(String sql, Object... args) {
       List<StoreAdminData> list = new ArrayList<StoreAdminData>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("GID");
                String name = rs.getString("Game");
                String nph = rs.getString("NPH");
                float price = rs.getFloat("GiaGame");
                
                String type = rs.getString("TheLoai");
                String pic = rs.getString("GamePic");
                String info = rs.getString("ThongTin");

                list.add(new StoreAdminData(id , name,nph , price , type,pic,info));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;}

    @Override
    protected List<StoreAdminData> SelectByType_combobox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
