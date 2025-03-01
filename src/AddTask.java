import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTask {
    BufferedReader br;
    int index=0;
    String taskName, taskDetail, query, status;
    Connection con;
    final String resetColor = "\u001B[0m";
    final String red = "\u001B[31m";
    final String cyan = "\u001B[36m";

    AddTask(int uId) {
//        Getting the user id...



        System.out.println("Add new Task");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter te task index: ");
            index = Integer.parseInt(br.readLine());
            System.out.print("Enter the name of the task: ");
            taskName=br.readLine();
            System.out.println("Enter the details of the task: ");
            taskDetail=br.readLine();
        } catch (IOException e){
            System.out.println(red+ "Enter the correct values"+ resetColor);
        } catch (NumberFormatException ne) {
            System.out.println(red +"The task index should be integer"+resetColor);
        }

        //Insert the task into the database
        con = ConnectionProvider.getConnection();
        status="Incomplete";
        query = "insert into task(id, taskIndex, name, about, status) values(?,?,?,?,?);";
        try {
            PreparedStatement pStmt = con.prepareStatement(query);
            pStmt.setInt(1, uId);
            pStmt.setInt(2,index);
            pStmt.setString(3,taskName);
            pStmt.setString(4,taskDetail);
            pStmt.setString(5,status);

            pStmt.executeUpdate();
            pStmt.close();
            con.close();
            System.out.println(cyan + "Task added successfully" + resetColor);
        } catch(SQLException se){
            System.out.println(red +"Unable to add task!!!" +resetColor);
        }
    }
}
