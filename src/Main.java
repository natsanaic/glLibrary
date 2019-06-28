import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String mainUserId;
    private static String mainUserName;
    private static String mainUserPassword;
    private static boolean mainUserLibrarian;

    public static void setMainUserId(String newMainUserId) {
        mainUserId = newMainUserId;
    }

    public String getMainUserId() {
        return mainUserId;
    }

    public static void setMainUserName(String newMainUserName) {
        mainUserName = newMainUserName;
    }

    public String getMainUserName() {
        return mainUserName;
    }

    public static void setMainUserPassword(String newMainUserPassword) {
        mainUserPassword = newMainUserPassword;
    }

    public String getMainUserPassword() {
        return mainUserPassword;
    }

    public static void setMainUserLibrarian(boolean newMainUserLibrarian) {
        mainUserLibrarian = newMainUserLibrarian;
    }

    public boolean getMainUserLibrarian() {
        return mainUserLibrarian;
    }

    public static void logIn() throws IOException {
        String staffID = "";
        String staffPassword = "";
        String staffName = "";
        boolean staffLibrarian = false;
        int targetIndex = -1;

        Scanner Scan = new Scanner(System.in);
        System.out.println(" Please enter your staff ID.");
        int i = 0;
        while (i == 0) {
            staffID = Scan.nextLine();
            targetIndex = glStaff.glStaffIdSearch(staffID);
            if (targetIndex >= 0) {
                i++;
            } else {
                System.out.println("Try again.");
            }
        }

        System.out.println(" Please enter your password.");
        i = 0;
        while (i == 0) {
            staffPassword = Scan.nextLine();
            if (staffPassword.equals(glStaff.glStaffs.get(targetIndex).getGlStaffPassword())) {
                i++;
            } else {
                System.out.println("Try again.");
            }
        }

        staffName = glStaff.glStaffs.get(targetIndex).getGlStaffName();
        staffLibrarian = glStaff.glStaffs.get(targetIndex).getLibrarian();

        setMainUserId(staffID);
        setMainUserName(staffName);
        setMainUserPassword(staffPassword);
        setMainUserLibrarian(staffLibrarian);

        showMainMenu();
    }

    public static void showMainMenu() throws IOException {
        Scanner Scan = new Scanner(System.in);
        int i = 0;
        while (i == 0) {
            System.out.println("=============================");
            System.out.println("     GL Library System");
            System.out.println(" User ID.: " + mainUserId + "   Name : " + mainUserName);
            System.out.println("-----------------------------");
            //System.out.println("[ 1 ]  ");
            System.out.println("[ 9 ]  GL Staff Manager.");
            System.out.println("[ 0 ]  Exit.");
            System.out.println("-----------------------------");
            System.out.println(" Please choose menu....");

            switch (Scan.nextInt()) {
                case 1 :

                    Scan.nextLine();
                    break;
                case 2 :
                    //i++;
                    //glStaffWriteToFile();
                    Book.bookPrintAll();
                    break;
                case 9 :
                    glStaff.glStaffMainMenu();
                    Scan.nextLine();
                    break;
                case 0 :

                    i++;
                    break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        glStaff.glStaffReadFromFile();
        Book.bookReadFromFile();
        String output = String.format("%s = %d", "joe", 35);
        System.out.println(output);
        System.out.printf("My name is: %s%n", "joe");


        //System.out.println(Book.Books);
        logIn();
        //Scanner Scan = new Scanner(System.in);
        //System.out.println("Welcome to GL library system.");
        //System.out.println("Please enter your staff ID.");

        //glStaff user = new glStaff("","","",false);
        //showMainMenu();
    }
}
