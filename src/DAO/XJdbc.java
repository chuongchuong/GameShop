/* Decompiler 7ms, total 283ms, lines 78 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XJdbc {
    
    
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost;database=EduSys;encrypt=true;trustServerCertificate=true";
    private static String username = "sa";
    private static String password = "songlong";

   
   public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
      Connection connection = DriverManager.getConnection(dburl, username, password);
      PreparedStatement pstmt = null;
      if (sql.trim().startsWith("{")) {
         pstmt = connection.prepareCall(sql);
      } else {
         pstmt = connection.prepareStatement(sql);
      }

      for(int i = 0; i < args.length; ++i) {
         ((PreparedStatement)pstmt).setObject(i + 1, args[i]);
      }

      return (PreparedStatement)pstmt;
   }

   public static void update(String sql, Object... args) {
      try {
         PreparedStatement stmt = getStmt(sql, args);

         try {
            stmt.executeUpdate();
         } finally {
            stmt.getConnection().close();
         }

      } catch (SQLException var7) {
         throw new RuntimeException(var7);
      }
   }

   public static ResultSet query(String sql, Object... args) {
      try {
         PreparedStatement stmt = getStmt(sql, args);
         return stmt.executeQuery();
      } catch (SQLException var3) {
         var3.printStackTrace();
         throw new RuntimeException(var3);
      }
   }

   public static Object value(String sql, Object... args) {
      try {
         ResultSet rs = query(sql, args);
         if (rs.next()) {
            return rs.getObject(0);
         } else {
            rs.getStatement().getConnection().close();
            return null;
         }
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   static {
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException var1) {
         throw new RuntimeException(var1);
      }
   }
}