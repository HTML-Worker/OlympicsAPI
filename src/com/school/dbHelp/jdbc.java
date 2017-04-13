/**
 * 
 */
/**
 * @author Long
 *
 */
package com.school.dbHelp;

import java.sql.*;
public class jdbc {
    static{
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static Connection getConn(){
        try{
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/olympics?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");       												
            return conn;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void close(Connection conn,Statement st,ResultSet rs){
    	if(rs!=null){
            try{
                rs.close();
            }catch(SQLException ex){
            }
       }
       if(st!=null){
           try {
               st.close();
           }catch(Exception ex){
           }
       }
       if(conn!=null){
           try{
               conn.close();
           }catch(Exception ex){
           }
       }
    }

}
