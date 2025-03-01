import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTask {
    Connection con;
    ViewTask(int uid){
        System.out.println("🌟✨ Your Bucket List ✨🌟");
        System.out.println("==============================================");

        // Show the tasks from db
        con =ConnectionProvider.getConnection();
        String query = "select * from task where id = ?";
        try {
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setInt(1,uid);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                int taskIndex = rs.getInt("taskIndex");
                String taskName = rs.getString("name");
                String taskDetails = rs.getString("about");
                String taskStatus = rs.getString("status");

                System.out.println("\uD83D\uDCDDIndex: " + taskIndex);
                System.out.println("\uD83D\uDCCCTask Name: " + taskName);
                System.out.println("\uD83D\uDCC2Task Details: " + taskDetails);
                System.out.println("✅Task status: " + taskStatus);
                System.out.println("_______________________________________");
            }
        } catch (SQLException e) {
            System.out.println("Unable to view task.");
        }
    }

    public static void main(String[] args) {
        new ViewTask(0);
    }
}

