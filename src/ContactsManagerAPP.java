import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContactsManagerAPP {

    public static void main(String[] args)  {

        init();

    }

    public static void init(){

        Path path = DirectoryUtil.getPath("src", "files", "contacts.txt");
        DirectoryUtil.tryCreateDir(DirectoryUtil.getPath("src", "files", "contacts.txt"));
        boolean cont = true;

        while(cont) {
            menuPrompt(path);
            cont = continueOrExit();
        }

    }

    public static void menuPrompt(Path path){

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit");
            System.out.print("Enter an option (1, 2, 3, 4, or 5): ");
            int userChoice = scanner.nextInt();

            menuDirection(userChoice, path);

        } catch(InputMismatchException e){
            System.out.println("Invalid input\n\n");
            e.printStackTrace();
            menuPrompt(path);
        } catch(IOException e){
            System.out.println("You shouldnt be here");
            e.printStackTrace();
            menuPrompt(path);
        }

    }

    public static void menuDirection (int choice, Path path) throws IOException {

            List<Contacts> contactsList = ContactsUtil.getContent(path);
            System.out.println("\n");

            if (choice == 1) {
                //view method
                ContactsUtil.printList(contactsList);
            } else if (choice == 2) {
                //add new contact method
                ContactsUtil.addContact(path);
            } else if (choice == 3) {
                // search by contact method
                ContactsUtil.searchContact(path);
            } else if (choice == 4) {
                // delete method
                ContactsUtil.deleteContact(path);
            } else if (choice == 5) {
                // exit method
                System.out.println("\n\nSayonara!");
                System.exit(0);

            } else {
                System.out.println("Invalid input! Please select a valid number.");
                menuPrompt(path);
            }

    }

    public static Boolean continueOrExit(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like to continue? (y/n): ");

        String answer = scanner.nextLine();

        System.out.println("\n");

        if (answer.equalsIgnoreCase("y")) {
            return true;
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("いとまごい!\n");
            return false;
        }else {
            System.out.println("Please input (y or n)!");
            continueOrExit();
        }

        System.out.println("Something bad happened Chief");
        return false;

    }


}
