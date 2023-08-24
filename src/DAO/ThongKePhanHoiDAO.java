
package DAO;

import Packet.StoreAdminData;
import Packet.ThongKePHDaTa;
import dao.SteamDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThongKePhanHoiDAO extends SteamDAO<ThongKePHDaTa, String>{
    String sql_insert = "insert into ThongKePhanHoi(IDS , Game , GiaGame , TheLoai) values (?,?,?,?,?)";
    String sql_update2 = "update ThongKePhanHoi set DanhGia=?,likes=? where IDS = ? ";
  
    String sql_all = "select * from ThongKePhanHoi";
    
    String sql_by_id = "select * from ThongKePhanHoi where  = ?";
    String sql = "select * from ThongKePhanHoi where TheLoai = ?";
    String sql2 = "select distinct TheLoai from ThongKePhanHoi";
    
    public List<ThongKePHDaTa> display_by_type(String type){
        List<ThongKePHDaTa> list = this.selectBySQL(sql , new Object[]{type});
        return list.size() > 0 ? list : null;
    }
    @Override
    public void insert(ThongKePHDaTa entity) {
       XJdbcHelper.update(sql_insert, new Object[]{entity.getIDS() , entity.getGame(),entity.getPrice(),entity.getTheLoai()});
    }

    @Override
    public void update(ThongKePHDaTa entity) {
    XJdbcHelper.update(sql_update2, new Object[]{  entity.getDanhGia(),entity.getLikes(),entity.getIDS()});
       
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ThongKePHDaTa> selectAll() {
        List<ThongKePHDaTa> list = selectBySQL(sql_all);
        return list.size() > 0 ? list : null;}

    @Override
    public ThongKePHDaTa selectById(String key) {
    List<ThongKePHDaTa> list = selectBySQL(sql_by_id , new Object[]{key});
        return list.size() > 0 ? list.get(0) : null;    
    }
    public List<ThongKePHDaTa> selectByKeyword(String keyword) {
      String sql = "SELECT * FROM ThongKePhanHoi WHERE TheLoai LIKE ?";
      return selectBySQL(sql, "%" + keyword + "%");
   }

    @Override
    protected List<ThongKePHDaTa> selectBySQL(String sql, Object... args) {
        List<ThongKePHDaTa> list = new ArrayList<ThongKePHDaTa>();
        try {
            
            ResultSet rs = XJdbcHelper.query(sql, args);
            while(rs.next()){
                String id = rs.getString("IDS");
                String name = rs.getString("Game");
                
                float price = rs.getFloat("GiaGame");
                
                String type = rs.getString("TheLoai");
                String danhgia = rs.getString("DanhGia");
                boolean likes =rs.getBoolean("Likes");
                String nph =null;
               
                list.add(new ThongKePHDaTa(id , name,nph , price , type,danhgia,likes));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<ThongKePHDaTa> SelectByType_combobox() {
    List<ThongKePHDaTa> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbcHelper.query(sql2);
            while(rs.next()){
                ThongKePHDaTa pro = new ThongKePHDaTa();
                pro.setTheLoai(rs.getString("TheLoai"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;      
    }
    
}
