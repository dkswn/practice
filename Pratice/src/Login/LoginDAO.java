package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String pwd = "GREEN1234";

   private Connection con;
   private Statement stmt;
   private ResultSet rs;

   public LoginVo list(String id, String pwd) {
      LoginVo data = new LoginVo();
      try {
         connDB();
         String query = "select * from profile ";
         if (id != null && pwd != null) {
            query += "where id = '" + id.toLowerCase() + "'";
            query += " and password = '" + pwd.toLowerCase() + "'";

         }
         System.out.println("SQL : " + query);
         
         // preparedStatement 에서 ?채우는 방법
        
         rs = stmt.executeQuery(query);
         rs.last();

         if (rs.getRow() == 0) {
            System.out.println("0 row selected.....");
         } else {
            System.out.println(rs.getRow() + "rows selected.....");
            rs.previous();
            while (rs.next()) {
               String pid = rs.getString("id");
               String ppwd = rs.getString("password");

               data.setId(pid);
               data.setPwd(ppwd);
            }
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
      return data;

   }

   private void connDB() {
      try {
         Class.forName(driver);
         System.out.println("jdbc driver loading success.");
         con = DriverManager.getConnection(url, user, pwd);
         System.out.println("oracle connection success.");
         stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         String query = null;
		//pstmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
         System.out.println("statement create success.");
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}