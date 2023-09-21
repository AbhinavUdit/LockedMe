import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class FileDetails {
    private String name;

    public FileDetails(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class LockedMeProtoType {
    private static ArrayList<FileDetails> files = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to LockedMe.com Prototype");
            System.out.println("Developer: Abhinav Udit Guria");
            System.out.println("1. View Files");
            System.out.println("2. Add File");
            System.out.println("3. Delete File");
            System.out.println("4. Search File");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    viewFiles();
                    break;
                case 2:
                    addFile(scanner);
                    break;
                case 3:
                    deleteFile(scanner);
                    break;
                case 4:
                    searchFile(scanner);
                    break;
                case 5:
                    System.out.println("Exiting LockedMe.com Prototype. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewFiles() {
        System.out.println("\nList of Files:");
        if (files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            // Sort files by name in ascending order
            Collections.sort(files, Comparator.comparing(FileDetails::getName));

            for (FileDetails file : files) {
                System.out.println(file.getName());
            }
        }
    }

    private static void addFile(Scanner scanner) {
        System.out.print("\nEnter the name of the file to add: ");
        String fileName = scanner.nextLine();
        files.add(new FileDetails(fileName));
        System.out.println("File '" + fileName + "' added successfully.");
    }

    private static void deleteFile(Scanner scanner) {
        System.out.print("\nEnter the name of the file to delete: ");
        String fileName = scanner.nextLine();

        boolean fileDeleted = false;
        for (FileDetails file : files) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                files.remove(file);
                fileDeleted = true;
                System.out.println("File '" + fileName + "' deleted successfully.");
                break;
            }
        }

        if (!fileDeleted) {
            System.out.println("File not found.");
        }
    }

    private static void searchFile(Scanner scanner) {
        System.out.print("\nEnter the name of the file to search: ");
        String fileName = scanner.nextLine();

        boolean fileFound = false;
        for (FileDetails file : files) {
            if (file.getName().equalsIgnoreCase(fileName)) {
                System.out.println("File '" + fileName + "' found.");
                fileFound = true;
                break;
            }
        }

        if (!fileFound) {
            System.out.println("File '" + fileName + "' not found.");
        }
    }
}
