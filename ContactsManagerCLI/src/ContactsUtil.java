import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContactsUtil {
    List<String> contentToWrite = new ArrayList<>();

    public static List<String> getContent(){
        List<String> contactList = new ArrayList<>();
        return contactList;
    }

    public static void addContact(List<String> contacts,Path path) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("You have selected: Add a new contact");
            System.out.println("First name: ");
            String firstName = sc.nextLine();
            System.out.println("Last name: ");
            String lastName = sc.nextLine();
            System.out.println("Phone Number: ");
            double phoneNumber = sc.nextDouble();
            Files.write(path, contacts, StandardOpenOption.APPEND);
            getContent().add(String.valueOf(new Contacts(firstName, lastName, phoneNumber)));
            System.out.println(firstName + " " + lastName + " has been successfully added to contacts");
        }catch(InputMismatchException | IOException e){
            System.out.println("Could not write to file at: " + path.toAbsolutePath());
        }

    }



}
