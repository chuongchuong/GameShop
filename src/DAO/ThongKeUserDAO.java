/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Packet.UserSignUpData;
import Packet.UserSignUpData;
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
public class ThongKeUserDAO extends SteamDAO<UserSignUpData,String>{

    
    String sql_all = "select * from ACCCOUNT";
    
    String sql_by_id = "select * from ACCOUNT where USERNAME  = ?";
    
    String sql2 = "select distinct TheLoai from StoreUser_Lib";
    

    @Override
    public void insert(UserSignUpData entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UserSignUpData entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserSignUpData> selectAll() {
         List<UserSignUpData> list = selectBySQL(sql_all);
        return list.size() > 0 ? list : null;    }

    @Override
    public UserSignUpData selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<UserSignUpData> selectByKeyword(String keyword) {
      String sql = "SELECT * FROM ACCCOUNT WHERE USERNAME LIKE ?";
      return selectBySQL(sql, "%" + keyword + "%");
   }

    @Override
    protected List<UserSignUpData> selectBySQL(String sql, Object... args) {
    List<UserSignUpData> list = new ArrayList<UserSignUpData>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("USERNAME");
                String name = rs.getString("GMAIL");
                String nph = rs.getString("PASS");
               
                list.add(new UserSignUpData(id , name,nph ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        
    }
    

    @Override
    protected List<UserSignUpData> SelectByType_combobox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
