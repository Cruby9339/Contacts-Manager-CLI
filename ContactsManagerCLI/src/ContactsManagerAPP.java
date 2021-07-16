import java.nio.file.Path;

public class ContactsManagerAPP {

    public static void main(String[] args) {



        init();


    }



    public static void init(){
        Path path = DirectoryUtil.getPath("src", "files", "contacts.txt");
        DirectoryUtil.tryCreateDir(DirectoryUtil.getPath("src", "files", "contacts.txt"));





    }


}
