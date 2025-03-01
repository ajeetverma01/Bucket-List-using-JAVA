import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class NewUserRegistration {
    void createAccount() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter user ID:");
            int uID = Integer.parseInt(br.readLine());
            System.out.print("Enter username:");
            String uName = br.readLine();
            System.out.print("Enter password:");
            String passW = br.readLine();

            Connection con = ConnectionProvider.getConnection();
            String query = "insert into user(userId, name, password) values(?,?,?)";
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setInt(1,uID);
            pStmt.setString(2,uName);
            pStmt.setString(3,passW);

            pStmt.executeUpdate();

            System.out.println("Account created successfully");
//            redirecting to dashboard...

            System.out.println("\nWelcome Mr. "+ uName + "\n");
            Dashboard d= new Dashboard();
            d.dashboard(uID);

            // Sending the user id to the AddTask class
            // Check karo ki data yha se bhi send hota hai ki nhi
//            new AddTask(uID);
            pStmt.close();
            con.close();
        } catch (IOException e) {
            System.out.println("Unable to take input.");
        } catch (NumberFormatException e) {
            System.out.println("User ID should be in number format.");
        } catch (SQLException e) {
            System.out.println("Unable to create account or it already exists");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        NewUserRegistration n = new NewUserRegistration();
        n.createAccount();
    }
}
