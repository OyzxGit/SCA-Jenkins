package cn.hxzy.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.Properties;

public class DataSource {
    private static LinkedList<Connection> pool = new LinkedList<>();

    static {
        try {
            InputStream inputStream = DataSource.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String driver = properties.getProperty("jdbc.driverClassName");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            Class.forName(driver);
            for (int i = 0; i < 10; i++) {
                try{
                    Connection connection = DriverManager.getConnection(url, username, password);
                    pool.add(connection);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public DataSource() {
    }

   public static Connection getConnection(){
        return pool.getFirst();
    }
    public static  void  closeConnection(Connection c){
        pool.addLast(c);
    }

}
