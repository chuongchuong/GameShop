/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Packet.StoreAdminData;
import Packet.UserLib;
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
public class UserDAO extends SteamDAO<UserLib,String>{
    String sql_insert = "insert into UserLibrary(GameID, Game , GiaGame , NPH,TheLoai,GamePic,ThongTin) values (?,?,?,?,?,?,?)";
    String sql_update2 = "update StoreUser_Lib set Game = ? , GiaGame = ? , NPH = ?,TheLoai=?,GamePic=?,ThongTin=? where IDGame = ? ";
  
    String sql_all = "select * from UserLibrary";
    
    String sql_by_id = "select * from StoreUser_Lib where  = ?";
    String sql = "select * from StoreUser_Lib where TheLoai = ?";
    String sql2 = "select distinct TheLoai from StoreUser_Lib";
    
    String sql_delete = "delete from UserLibrary where GameID = ?";
    @Override
    public void insert(UserLib entity) {
        XJdbcHelper.update(sql_insert, new Object[]{entity.getIDD() , entity.getGame(),entity.getPrice(),entity.getNPH(),entity.getTheLoai(),entity.getGamePic(),entity.getThongTin()});
    }

    @Override
    public void update(UserLib entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
    XJdbcHelper.update(sql_delete, new Object[]{key });    
    }

    @Override
    public List<UserLib> selectAll() {
    List<UserLib> list = selectBySQL(sql_all);
        return list.size() > 0 ? list : null;    
    }

    @Override
    public UserLib selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<UserLib> selectBySQL(String sql, Object... args) {
    List<UserLib> list = new ArrayList<UserLib>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("GameID");
                String name = rs.getString("Game");
                String nph = rs.getString("NPH");
                float price = rs.getFloat("GiaGame");
                
                String type = rs.getString("TheLoai");
                String pic = rs.getString("GamePic");
                String info = rs.getString("ThongTin");

                list.add(new UserLib(id , name,nph , price , type,pic,info));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }

    @Override
    protected List<UserLib> SelectByType_combobox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
