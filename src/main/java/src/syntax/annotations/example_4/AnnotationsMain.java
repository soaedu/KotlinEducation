package src.syntax.annotations.example_4;

import syntax.annotations.example_4.File;

import java.io.FileNotFoundException;

public class AnnotationsMain {
    public static void main(String[] args) {
        // #1 no '@Throws' annotation
        // throwsException();

        // #2 with '@Throws' annotation
        try {
            throwsException();
        } catch(FileNotFoundException e) {
            System.out.println("Error: " +e.getMessage());
        }
    }

    // #1 no '@Throws' annotation
    /*public static void throwsException() {
        boolean exists = new File("someFile.txt").exists();
        System.out.println("File exists: " +exists);
    }*/

    // #2 with '@Throws' annotation
    public static void throwsException() throws FileNotFoundException {
        boolean exists = new File("someFile.txt").exists();
        System.out.println("File exists: " +exists);
    }
}
