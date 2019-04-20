package zz.xy.factory;

import zz.xy.dao.sql.AbstractSQL;
import zz.xy.dao.sql.RoleSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl" ;
    private static final String USER = "c##mazongyang" ;
    private static final String PWD = "123456" ;

    private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>() ;

    private static Connection getConnection(){
        Connection conn = connectionThreadLocal.get() ;
        if (conn == null){
            try {
                conn = DriverManager.getConnection(DBURL, USER, PWD) ;
            } catch (SQLException e){
                e.printStackTrace();
            }
            connectionThreadLocal.set(conn);
        }
        return conn ;
    }

    public static void closeConnection(){
        Connection connection = connectionThreadLocal.get() ;
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connectionThreadLocal.remove();
    }
    public static PreparedStatement getPreparedStatement(String sql){
        PreparedStatement preparedStatement = null ;
        try {
            preparedStatement = getConnection().prepareStatement(sql) ;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement ;
    }

}
