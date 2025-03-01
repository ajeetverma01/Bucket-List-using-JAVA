import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeTaskStatus {
    Connection con;
    final String resetColor = "\u001B[0m";
    final String green = "\u001B[32m";
    final String red = "\u001B[31m";
    final String cyan = "\u001B[36m";


    void changeStatus(int uid) {
        String clearConsole = "\033[H\033[2J";
        System.out.print(clearConsole);

        System.out.println("here are all the tasks: ");
        new ViewTask(uid);

        System.out.print(green + "Enter the task index to change the status: " + resetColor);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        try {
            con =ConnectionProvider.getConnection();
            int taskIndex = Integer.parseInt(br.readLine());
            boolean taskStatus = getStatus(uid, taskIndex);
            String query1 = "UPDATE task SET status = 'Completed' WHERE id = ? AND taskIndex = ?;";
            String query2 = "UPDATE task SET status = 'Incomplete' WHERE id = ? AND taskIndex = ?;";
            PreparedStatement pStmt;
            if (taskStatus) {
                pStmt = con.prepareStatement(query1);
                System.out.println(cyan + "The status is changed to Completed" +resetColor);
            }
            else {
                pStmt = con.prepareStatement(query2);
                System.out.println(cyan + "The status is changed to Incomplete" + resetColor);
            }
            pStmt.setInt(1, uid);
            pStmt.setInt(2,taskIndex);
            pStmt.executeUpdate();

            pStmt.close();
            con.close();
        } catch (IOException e) {
            System.out.println(red + "Unable to take input." + resetColor);
        }
        catch (NumberFormatException e) {
            System.out.println(red +"Task index should be in integer format."+ resetColor);
        } catch (SQLException e) {
            System.out.println(red +"Unable to change status!!!"+ resetColor);
        }

    }

    boolean getStatus(int uid, int taskIndex){
        Connection con1 =ConnectionProvider.getConnection();
        String queryForStatus = "select status from task where id = ? AND taskIndex=?";
        ResultSet rs;
        boolean st = false;
        try {
            PreparedStatement pStmt = con1.prepareStatement(queryForStatus);
            pStmt.setInt(1,uid);
            pStmt.setInt(2,taskIndex);
            rs = pStmt.executeQuery();
            while(rs.next()) {
                String status = rs.getString("status");
                st = status.equalsIgnoreCase("Incomplete");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return st;
//        return "";
    }
}