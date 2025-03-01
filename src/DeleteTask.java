import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTask {
    Connection con;
    BufferedReader br;
    PreparedStatement pStmt;
    int taskIndex;
    String query;
    public void deleteTask(int userId) {
        con=ConnectionProvider.getConnection();
        br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Delete a Task");
        System.out.print("Enter the task index to delete the task: ");
        try {
            taskIndex = Integer.parseInt(br.readLine());
            query = "Delete from task where taskIndex = ? AND id = ?;";
            pStmt = con.prepareStatement(query);
            pStmt.setInt(1, taskIndex);
            pStmt.setInt(2,userId);
            int a = pStmt.executeUpdate();
            if (a!=0){
                System.out.println("Task deleted.");
            }
            else System.out.println("No task found on this index");


            pStmt.close();
            con.close();
        } catch (IOException e) {
            System.out.println("Enter the valid index!!!");
        } catch (SQLException e) {
            System.out.println("Unable to delete task!!!");
        }
    }
}