import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class glStaff {

    private String glStaffId;
    private String glStaffName;
    private String glStaffPassword;
    private boolean isLibrarian;
    public static final ArrayList<glStaff> glStaffs = new ArrayList<glStaff>();

    public glStaff() {
        Scanner Scan = new Scanner(System.in);

        System.out.println("Please enter new staff ID.");
        int i = 1;
        String search = "";
        while (i == 1) {
            search = Scan.nextLine();
            for (int iLoop = 0; iLoop < glStaffs.size(); iLoop++) {
                if (glStaffs.get(iLoop).glStaffId.equals(search)) {
                   System.out.println("Duplicate ID!!! Please enter new ID.");
                   break;
                } else if (iLoop == glStaffs.size()-1) {
                          i++;
                       }
            }
        }
        setGlStaffId(search);

        System.out.println("Please enter staff name.");
        setGlStaffName(Scan.nextLine());

        glStaffPassword = "9999";

        System.out.println("Is he/she librarian? [Y] Yes or [N] No.");
        isLibrarian = ("Y".equals(Scan.nextLine()));

        glStaffs.add(this);
        System.out.println("---------------------------------------------------");
        System.out.println("New user: " + toString());
        System.out.println("---------------------------------------------------");
    }

    public glStaff(String newID,String newName, String newPassword, boolean newLibrarianStatus) {
        setGlStaffId(newID);
        setGlStaffName(newName);
        setGlStaffPassword(newPassword);
        setLibrarian(newLibrarianStatus);
        glStaffs.add(this);
    }

    public glStaff(String line) {
        String[] fields = line.split("\\|");
        setGlStaffId(fields[0]);
        setGlStaffName(fields[1]);
        setGlStaffPassword(fields[2]);
        setLibrarian(Boolean.valueOf(fields[3]));
        glStaffs.add(this);
    }

    // Set staff ID.
    public void setGlStaffId(String newGlStaffId) {
        glStaffId = newGlStaffId;
    }

    // Get staff ID.
    public String getGlStaffId() {
        return glStaffId;
    }

    // Set staff name.
    public void setGlStaffName(String newGlStaffName) {
        glStaffName = newGlStaffName;
    }

    // Get staff name.
    public String getGlStaffName() {
        return glStaffName;
    }

    // Set staff password.
    public void setGlStaffPassword(String newGlStaffPassword) {
        glStaffPassword = newGlStaffPassword;
    }

    // Get staff password.
    public String getGlStaffPassword() {
        return glStaffPassword;
    }

    // Set staff librarian status.
    public void setLibrarian(boolean newIsLibrarian) {
        isLibrarian = newIsLibrarian;
    }

    // Get staff librarian status.
    public boolean getLibrarian() {
        return isLibrarian;
    }

    public static void glStaffReadFromFile() throws IOException{
        File glStaffFile = new File("D:\\Java\\Tutorials\\glLibrary\\src\\glStaff.txt");
        Scanner glStaffFileReader = new Scanner(glStaffFile);
        while (glStaffFileReader.hasNextLine()) {
            new glStaff(glStaffFileReader.nextLine());
        }
    }

    public static void glStaffWriteToFile() throws IOException{
        FileWriter glStaffFile = new FileWriter("D:\\Java\\Tutorials\\glLibrary\\src\\glStaff.txt");
        BufferedWriter outStream = new BufferedWriter(glStaffFile);

        for (int i = 0; i < glStaffs.size(); i++) {
            outStream.write(glStaffs.get(i).glStaffId + "|"
                    + glStaffs.get(i).glStaffName + "|"
                    + glStaffs.get(i).glStaffPassword + "|"
                    + glStaffs.get(i).isLibrarian
            );
            if (i != glStaffs.size()-1) {
                outStream.newLine();
            }
        }
        outStream.close();
    }

    public static void editGlStaff() {

    }

    public static void glStaffChangePassword() {

    }

    public static int glStaffIdSearch(String keyword) {
        int intResult = -1;
        for (int i = 0; i < glStaffs.size(); i++) {
            if (keyword.equals(glStaffs.get(i).glStaffId)) {
                intResult = i;
            }
        }
        return intResult;
    }

    public static void glStaffPrintAll() {
        System.out.println("==================================");
        System.out.println(" GL staff list.");
        System.out.println("----------------------------------");
        for (int i = 0; i < glStaffs.size(); i++) {
            System.out.println(glStaffs.get(i));
        }
        System.out.println("----------------------------------");
    }

    public static void glStaffMainMenu() throws IOException {
        Scanner Scan = new Scanner(System.in);
        int i = 0;
        while (i == 0) {
            System.out.println("=======================");
            System.out.println("  GL Staff Manager");
            System.out.println("-----------------------");
            System.out.println("[ 1 ]  Add new staff.");
            System.out.println("[ 2 ]  Edit staff.");
            System.out.println("[ 3 ]  Print all staff.");
            System.out.println("[ 0 ]  Back to main menu.");
            System.out.println("-----------------------");
            System.out.println(" Please choose menu....");
            switch (Scan.nextInt()) {
                case 1 :
                    new glStaff();
                    Scan.nextLine();
                    break;
                case 2 :
                    //editGlStaff();
                    //Scan.nextLine();
                    break;
                case 3 :
                    glStaffPrintAll();
                    Scan.nextLine();
                    break;
                case 0 :
                    glStaffWriteToFile();
                    i++;
                    break;


            }

        }
    }

    //public static String modifyGlStaff() {
    //}

    public String toString() {
        String librarian = ((isLibrarian) ? "Librarian" : " ");
        return "ID.: " + glStaffId + "   Name: " + glStaffName + "   [" + librarian + "]";
    }

    //public static void cls() throws IOException, InterruptedException {
    //    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    //}

    public static void main(String[] args) throws IOException {
        //glStaffReadFromFile();
        //glStaffMainMenu();
        //int i = 0;
        //while (int i = 1) {

        //}

        //new glStaff();
        //File file1 = new File("D:\\Java\\Tutorials\\glLibrary\\src\\glStaff.txt");
        //Scanner fileReader1 = new Scanner(file1);
        //while (fileReader1.hasNextLine()) {
        //    new glStaff(fileReader1.next());
        //}



        //System.out.println(glStaffs.get(glStaffs.size()-1));

        //int status = fileChooser.showOpenDialog(null);

        //glStaff staff02 = new glStaff();
        //System.out.println(glStaffs.get(glStaffs.size()-1));

        //glStaff staff03 = new glStaff("555","xxx","5050",true);
        //glStaff staff04 = new glStaff("666","yyy","6060",false);
        //glStaff staff05 = new glStaff("777","zzz","7070",true);
        //new glStaff("888","hhh","8080",true);
        //new glStaff("63373|Natsanai|1010|true");
        //Book.main(null);

        //for (int i = 0; i < glStaffs.size(); i++) {
        //    System.out.println(glStaffs.get(i));
        //}

        //glStaffPrintAll();

        //System.out.println(staff01.toString());
        //System.out.println(staff02.toString());

        //System.out.println(getGlStaffId(staff01));


    }
}
