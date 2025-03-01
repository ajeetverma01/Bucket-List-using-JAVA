import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        final String resetColor = "\u001B[0m";
        final String green = "\u001B[32m";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1 for creating a new account\nEnter 2 for log in into existing account");
        System.out.print(green + "Enter you choice: " +resetColor);
        try {
            int choice = Integer.parseInt(br.readLine());
            if (choice == 1 ) {
              NewUserRegistration nr = new NewUserRegistration();
              nr.createAccount();
            }
            else if (choice == 2) {
               new UserLogin();
            }
            else {
                System.out.print("Wrong input!!!\nClosing the program");
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
        } catch (IOException e) {
            System.out.println("Unable to take input");
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid input");
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}