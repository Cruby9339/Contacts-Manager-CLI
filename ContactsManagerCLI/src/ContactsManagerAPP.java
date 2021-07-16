import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactsManagerAPP {

    public static void main(String[] args) {



        init();


        menuPrompt();

    }



    public static void init(){

        Path path = DirectoryUtil.getPath("src", "files", "contacts.txt");
        DirectoryUtil.tryCreateDir(DirectoryUtil.getPath("src", "files", "contacts.txt"));


    }

    public static void menuPrompt(){

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit");
            System.out.print("Enter an option (1, 2, 3, 4, or 5): ");
            int userChoice = scanner.nextInt();

            System.out.println(userChoice);

            menuDirection(userChoice);

        } catch(InputMismatchException e){
            System.out.println("Invalid input\n\n");
            menuPrompt();
        }

    }

    public static void menuDirection (int choice){

            if (choice == 1) {
                //view method
                System.out.println("hello from 1");
            } else if (choice == 2) {
                // add a new contact method
                System.out.println("TWO");
            } else if (choice == 3) {
                // search by contact method
                System.out.println("T H R E E");
            } else if (choice == 4) {
                // delete method
                System.out.println("4");
            } else if (choice == 5) {
                // exit method
                System.out.println("F5ve");
            } else {
                System.out.println("Invalid input! Please select a valid number.");
                menuPrompt();
            }

    }


}
