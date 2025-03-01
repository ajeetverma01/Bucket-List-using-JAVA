import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Dashboard {
    int uId;
    final String resetColor = "\u001B[0m";
    final String yellow = "\u001B[33m";
    final String green = "\u001B[32m";
    final String red = "\u001B[31m";
    void dashboard(int uid) throws IOException, InterruptedException {
        uId = uid;

        System.out.println(yellow + """
                |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
                |  Enter 1 for Adding a new task          |
                |  Enter 2 for Viewing all the tasks      |
                |  Enter 3 for deleting the tasks         |
                |  Enter 4 for Changing status of a task  |
                |  Enter 0 for exit                       |
                |_________________________________________|
                """ + resetColor);
        System.out.print(green + "Enter your choice : " + resetColor);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1 -> {
                    new AddTask(uid);
                    runAgain();
                }
                case 2 -> {
                    new ViewTask(uid);
                    runAgain();
                }
                case 3 -> {
                    DeleteTask dTask = new DeleteTask();
                    dTask.deleteTask(uid);
                    runAgain();
                }
                case 4 -> {
                    ChangeTaskStatus cht = new ChangeTaskStatus();
                    cht.changeStatus(uid);
                    runAgain();
                }
                case 0 -> System.exit(0);
                default -> System.out.println(red + "Wrong input" + resetColor);
            }
        } catch (NumberFormatException e) {
            System.out.println(red + "Wrong input" + resetColor);
        }
    }

    void runAgain() throws IOException, InterruptedException {
        System.out.print(green + "Run the project again (y/n): "+ resetColor);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res = br.readLine();

        if (res.equalsIgnoreCase("y") || res.equalsIgnoreCase("yes") || res.equalsIgnoreCase("1")) {
            String clearConsole = "\033[H\033[2J";
            System.out.print(clearConsole);
            System.out.flush();
            dashboard(uId);
        }
        else if (res.equalsIgnoreCase("n") || res.equalsIgnoreCase("no") || res.equalsIgnoreCase("0")) System.exit(0);
        else System.out.print(red + "Wrong input!!!\nClosing the program" + resetColor);
        {
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.print(".");
            Thread.sleep(100);
            System.out.println(".");
        }
    }
}