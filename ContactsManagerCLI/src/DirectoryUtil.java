import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryUtil {





    public static Path getPath(String parentDirectory, String childDirectory, String fileName) {
        return Paths.get(parentDirectory, childDirectory, fileName);
    }

    public static boolean doesPathExist(Path path) {
        return Files.exists(path);
    }

    public static void tryCreateDir(Path pathToCreate) {
        if (!doesPathExist(pathToCreate)) {
            try {
                Files.createDirectory(pathToCreate);
            } catch (IOException e) {
                System.out.println("Could not create the dir at: ");
                System.out.println(pathToCreate.toAbsolutePath());
            }
        } else {
            System.out.println("The path at " + pathToCreate.toAbsolutePath() + " already exists");
        }

    }

}
