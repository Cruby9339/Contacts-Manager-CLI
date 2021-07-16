import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactsManagerAPP {

    public static void main(String[] args) throws IOException {

        init();

    }

    public static void init() throws IOException {

        Path path = DirectoryUtil.getPath("src", "files", "contacts.txt");
        DirectoryUtil.tryCreateDir(DirectoryUtil.getPath("src", "files", "contacts.txt"));

        menuPrompt(path);

    }

    public static void menuPrompt(Path path)throws IOException{

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("1. View contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit");
            System.out.print("Enter an option (1, 2, 3, 4, or 5): ");
            int userChoice = scanner.nextInt();

//            System.out.println(userChoice);

            menuDirection(userChoice, path);

        } catch(InputMismatchException e){
            System.out.println("Invalid input\n\n");
            e.printStackTrace();
            menuPrompt(path);
        }

    }

    public static void menuDirection (int choice, Path path) throws IOException {

            if (choice == 1) {
                //view method
                ContactsUtil.tryPrintContents(path);
            } else if (choice == 2) {
                //add new contact method
                ContactsUtil.addContact(path);
            } else if (choice == 3) {
                // search by contact method
                ContactsUtil.searchContact(path);
                System.out.println("T H R E E");
            } else if (choice == 4) {
                // delete method
                ContactsUtil.deleteContact(path);
                System.out.println("4");
            } else if (choice == 5) {
                // exit method
                System.out.println("\n\nSayonara!");
                System.exit(0);

            } else {
                System.out.println("Invalid input! Please select a valid number.");
                menuPrompt(path);
            }

    }


}
