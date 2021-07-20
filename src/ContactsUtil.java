import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ContactsUtil {


    public static List<Contacts> getContent(Path path) throws IOException {

        List<String> contactStringList = readFromFile(path);
        List<Contacts> contactList = new ArrayList<>();
        for (String cs : contactStringList){
            String[] contactArr = cs.split("\\|");
            contactList.add(new Contacts(contactArr[0], contactArr[1]));

        }
        return contactList;
    }

    public static List<String> stringContent(List<Contacts> contacts){

        List<String> stringList = new ArrayList<>();

        for (Contacts contact : contacts) {
            stringList.add(contact.toString());
        }

        return stringList;
    }

    public static void addContact(Path path) throws IOException {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("You have selected: Add a new contact");
            System.out.print("First name: ");
            String firstName = sc.nextLine();
            System.out.print("Last name: ");
            String lastName = sc.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = sc.nextLine();
            List<Contacts> contactsList = getContent(path);
            contactsList.add(new Contacts(firstName + " " +lastName + "\t\t", "\t   " + phoneNumber));

            Files.write(path, stringContent(contactsList));

            System.out.println(firstName + " " + lastName + " has been successfully added to contacts");

        } catch (InputMismatchException | IOException e) {
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }

    }

    public static void deleteContact(Path path) throws IOException {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Contact to delete (Full name or Phone number): ");
            String contactToDelete = sc.nextLine().toLowerCase();

            List<String> ContactList;
            ContactList = Files.readAllLines(path);
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
            Files.write(path, newContactList);

        } catch (IOException e) {
            System.out.println("User/Phone number does not exist");
        }

    }

    public static void searchContact(Path path) throws IOException {

        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a name or number to search: ");
            String contactToFind = sc.nextLine().toLowerCase();
            List<String> contactList;
            contactList = Files.readAllLines(path);
            for(String contact : contactList){
                if(contact.toLowerCase().contains(contactToFind)){
                    System.out.println("Contact: " + contact);
                }
            }

        }catch(IOException e){
            System.out.println("Could not find user using those values");
        }

    }

    public static List<String> readFromFile(Path path) throws IOException {

        return Files.readAllLines(path);

    }


    public static void printList(List<Contacts> contactsList) throws IOException {

        System.out.println("Name\t\t\t\t|\t  Phone number");
        System.out.println("---------------------------------------");

        for (Contacts contact : contactsList) {
            System.out.println(contact.getFullName() + "\t|" + contact.getPhoneNumber());
        }

        System.out.println("\n");

    }


}
