/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Packet.NapTheDATA;
import Packet.NapTheDATA;
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
public class NapTheDAO extends SteamDAO<NapTheDATA,String>{
String sql_update2 = "update ACCCOUNT set MONEYY = MONEYY + ?  where USERNAME = ? ";
String sql_update3 = "update ACCCOUNT set MONEYY = MONEYY - ?  where USERNAME = ? ";
    @Override
    public void insert(NapTheDATA entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(NapTheDATA entity) {
    XJdbcHelper.update(sql_update2, new Object[]{entity.getMoney(),entity.getUserName()});    
    }
    
    public void update2(NapTheDATA entity) {
    XJdbcHelper.update(sql_update3, new Object[]{entity.getMoney(),entity.getUserName()});    
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NapTheDATA> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NapTheDATA selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<NapTheDATA> selectByKeyword(String keyword) {
      String sql = "SELECT MONEYY FROM ACCCOUNT WHERE USERNAME = ?";
      return selectBySQL(sql,  keyword );
   }

    @Override
    protected List<NapTheDATA> selectBySQL(String sql, Object... args) {
    List<NapTheDATA> list = new ArrayList<NapTheDATA>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("USERNAME");
                
                float money = rs.getFloat("MONEYY");
                
                
                
                list.add(new NapTheDATA(id ,money ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }

    @Override
    protected List<NapTheDATA> SelectByType_combobox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
