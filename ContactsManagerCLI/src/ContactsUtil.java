import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsUtil {

    public static List<String> getContent(){
        List<String> contactList = new ArrayList<>();
        return contactList;
    }

    public static void addContact(Path path) {
        System.out.println(path);

        try {
            Path pathToFile = Paths.get("ContactsManagerCLI","src", "files", "contacts.txt");
            Scanner sc = new Scanner(System.in);
            System.out.println("You have selected: Add a new contact");
            System.out.println("First name: ");
            String firstName = sc.nextLine();
            System.out.println("Last name: ");
            String lastName = sc.nextLine();
            System.out.println("Phone Number: ");
            int phoneNumber = sc.nextInt();
            Files.write(pathToFile, Collections.singletonList(firstName + " " + lastName + " " + phoneNumber), StandardOpenOption.APPEND);
            getContent().add(new Contacts(firstName, lastName, phoneNumber).toString());
            System.out.println(firstName + " " + lastName + " has been successfully added to contacts");
        }catch(InputMismatchException | IOException e){
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }

    }



}
