import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsUtil {


    public static List<String> getContent() {
        List<String> contactList = new ArrayList<>();
        return contactList;
    }

    public static void addContact(Path path) {

        System.out.println(path);

        try {
            Path pathToFile = Paths.get("ContactsManagerCLI", "src", "files", "contacts.txt");
            Scanner sc = new Scanner(System.in);
            System.out.println("You have selected: Add a new contact");
            System.out.print("First name: ");
            String firstName = sc.nextLine();
            System.out.print("Last name: ");
            String lastName = sc.nextLine();
            System.out.print("Phone Number: ");
            int phoneNumber = sc.nextInt();
            Files.write(pathToFile, Collections.singletonList(firstName + " " + lastName + "\t\t|\t" + phoneNumber), StandardOpenOption.APPEND);
            getContent().add(new Contacts(firstName, lastName, phoneNumber) + "\n");
            System.out.println(firstName + " " + lastName + " has been successfully added to contacts");

            // looping application
            ContactsManagerAPP.continueOrExit();

        } catch (InputMismatchException | IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }

    }

    public static void deleteContact(Path path) {

        try {
            System.out.println(path);
            Scanner sc = new Scanner(System.in);
            System.out.print("Contact to delete (Full name or Phone number): ");
            String contactToDelete = sc.nextLine();
            Path pathToFile = Paths.get("ContactsManagerCLI", "src", "files", "contacts.txt");
            List<String> ContactList;
            ContactList = Files.readAllLines(pathToFile);
            List<String> newContactList = new ArrayList<>();
            for (String person : ContactList) {
                if (person.toLowerCase().contains(contactToDelete)) {
                    continue;
                }
                newContactList.add(person);
            }
            for (String contact : newContactList) {
                System.out.println(contact);
            }
            Files.write(pathToFile, newContactList);

            // looping application
            ContactsManagerAPP.continueOrExit();

        } catch (IOException e) {
            System.out.println("User/Phone number does not exist");
        }

    }

    public static void searchContact(Path path){

        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a name or number to search");
            String contactToFind = sc.nextLine();
            Path pathToFile = Paths.get("ContactsManagerCLI", "src", "files", "contacts.txt");
            List<String> contactList;
            contactList = Files.readAllLines(pathToFile);
            for(String contact : contactList){
                if(contact.toLowerCase().contains(contactToFind)){
                    System.out.println("Contact: " + contact);
                }
            }

            // looping application
            ContactsManagerAPP.continueOrExit();

        }catch(IOException e){
            System.out.println("Could not find user using those values");
        }

    }

    public static List<String> readFromFile(Path path) throws IOException {

        return Files.readAllLines(path);

    }

    public static void tryPrintContents(Path path) {

        try {
            Path pathToFile = Paths.get("ContactsManagerCLI", "src", "files", "contacts.txt");
            ContactsUtil.printList(ContactsUtil.readFromFile(pathToFile));
        } catch (IOException e) {
            System.out.println("Unable to read contents of the file at: " + path.toAbsolutePath());
        }

    }

    public static void printList(List<String> strings) throws IOException {

        System.out.println("Name            |   Phone number");
        System.out.println("------------------------------------");

        for (String line : strings) {
            System.out.println(line);
        }

        System.out.println("\n");
        // looping application
        ContactsManagerAPP.continueOrExit();

    }


}
