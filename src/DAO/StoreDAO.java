/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


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
public class StoreDAO extends SteamDAO<StoreUserData,String>{
    String sql_insert = "insert into StoreUser_Lib(id , fullname , price , type_pro) values (?,?,?,?)";
    String sql_update2 = "update StoreUser_Lib set Game = ? , GiaGame = ? , NPH = ?,TheLoai=?,GamePic=?,ThongTin=? where IDGame = ? ";
  
    String sql_all = "select * from StoreUser_Lib";
    
    String sql_by_id = "select * from StoreUser_Lib where  = ?";
    String sql = "select * from StoreUser_Lib where TheLoai = ?";
    String sql2 = "select distinct TheLoai from StoreUser_Lib";
    
    public List<StoreUserData> display_by_type(String type){
        List<StoreUserData> list = this.selectBySQL(sql , new Object[]{type});
        return list.size() > 0 ? list : null;
    }
    
    @Override
    public List<StoreUserData> selectAll() {
     List<StoreUserData> list = selectBySQL(sql_all);
        return list.size() > 0 ? list : null;    
    }

    @Override
    public StoreUserData selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<StoreUserData> selectBySQL(String sql, Object... args) {
        List<StoreUserData> list = new ArrayList<StoreUserData>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("IDGame");
                String name = rs.getString("Game");
                String nph = rs.getString("NPH");
                float price = rs.getFloat("GiaGame");
                
                String type = rs.getString("TheLoai");
                String pic = rs.getString("GamePic");
                String info = rs.getString("ThongTin");
                
                list.add(new StoreUserData(id , name,nph , price , type,pic,info));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<StoreUserData> selectByKeyword(String keyword) {
      String sql = "SELECT * FROM StoreUser_Lib WHERE Game LIKE ?";
      return selectBySQL(sql, "%" + keyword + "%");
   }

    @Override
    public List<StoreUserData> SelectByType_combobox() {
    List<StoreUserData> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbcHelper.query(sql2);
            while(rs.next()){
                StoreUserData pro = new StoreUserData();
                pro.setTheLoai(rs.getString("TheLoai"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    

    @Override
    public void insert(StoreUserData entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(StoreUserData entity) {
         XJdbcHelper.update(sql_update2, new Object[]{  entity.getGame(),entity.getPrice(),entity.getNPH(),entity.getTheLoai(),entity.getGamePic(),entity.getThongTin(),entity.getIDGame()});
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
