public class Contacts {

    private String firstName;
    private String lastName;
    private int phoneNumber;

    public Contacts(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Contacts() {

    }

    public String contactsToString(){
        return this.firstName + "" + this.lastName + " " +  "Phone number: " + this.phoneNumber;
    }

}
