/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Packet.ThongKeHoanTraDATA;

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
public class TKHoanTraDAO extends SteamDAO<ThongKeHoanTraDATA,String>{

    String sql_all = "select * from ThongKeHoanTra";
    
   
    
    @Override
    public void insert(ThongKeHoanTraDATA entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ThongKeHoanTraDATA entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ThongKeHoanTraDATA> selectAll() {
    List<ThongKeHoanTraDATA> list = selectBySQL(sql_all);
        return list.size() > 0 ? list : null;    
    }

    @Override
    public ThongKeHoanTraDATA selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<ThongKeHoanTraDATA> selectBySQL(String sql, Object... args) {
    List<ThongKeHoanTraDATA> list = new ArrayList<ThongKeHoanTraDATA>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("IDS");
                String name = rs.getString("Game");
                
                float price = rs.getFloat("GiaGame");
                
                
               
                list.add(new ThongKeHoanTraDATA(id , name, price ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }

    @Override
    protected List<ThongKeHoanTraDATA> SelectByType_combobox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
