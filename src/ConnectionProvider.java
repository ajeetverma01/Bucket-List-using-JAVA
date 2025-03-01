import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

class ConnectionProvider
        {
            static Connection con = null;
            static String url="jdbc:mysql://localhost:3306/bucket_list";
            static String username = "root";
            static String password = "";

            public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e){
                System.out.println("Driver Not Found!!!");
            }
            catch (SQLException e){
                System.out.println("Unable to create connection!!!\nTurn the SQL connection on.");
                System.exit(0);
            }  return con;
    }
}