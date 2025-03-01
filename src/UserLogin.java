import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLogin {
    Connection con;

    UserLogin() {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=====================================");
        System.out.println("🔐 Enter your details to login 🔐");
        System.out.println("=====================================\n");
        try {
            System.out.print("\uD83D\uDC64Enter User ID : ");
            int userID = Integer.parseInt(br.readLine());
            System.out.print("\uD83D\uDD11Enter password : ");
            String password = br.readLine();

            con = ConnectionProvider.getConnection();
            Statement stmt =con.createStatement();
            String query = "select * from user;";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\n===========================================");

            while (rs.next()){
                int data1 = rs.getInt("userId");
                String data2 = rs.getString("password");
                String name = rs.getString("name");

                if (data1==userID && data2.equals(password)) {
                    System.out.println("✅ Login Successful! Welcome, " + name + "!");
                    System.out.println("===========================================");
                    Dashboard d= new Dashboard();
                    d.dashboard(userID);
                    break;
                }

//                This statement will cause an exception
                else {
                    System.out.println("❌ Invalid Username or Password. Please try again.");
                }
                System.out.println("===========================================");
            }

            stmt.close();
            con.close();
        } catch (IOException e) {
            System.out.println("Unable to take input.");
        }
        catch (SQLException e){
            System.out.println("Unable to login...");
        }
        catch (NumberFormatException e){
            System.out.println("User id should be in integer format.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}