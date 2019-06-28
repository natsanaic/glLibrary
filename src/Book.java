import java.io.File;
import java.io.IOException;
import java.util.*;

public class Book {
    private String bookId;
    private String bookName;
    private String bookCategory;
    private String bookWriter;
    private String bookShortStory;
    private String bookStatus; // A: Active, N: Non-Active, R: Repair

    public static final ArrayList<Book> Books = new ArrayList<Book>();

    public Book() {

    }

    public Book(String newBookId, String newBookName, String newBookCategory, String newBookWriter, String newBookShortStory, String newBookStatus) {
        setBookId(newBookId);
        setBookName(newBookName);
        setBookCategory(newBookCategory);
        setBookWriter(newBookWriter);
        setBookShortStory(newBookShortStory);
        setBookStatus(newBookStatus);
        Books.add(this);
    }

    public Book(String line) {
        String[] fields = line.split("\\|");
        setBookId(fields[0]);
        setBookName(fields[1]);
        setBookCategory(fields[2]);
        setBookWriter(fields[3]);
        setBookShortStory(fields[4]);
        setBookStatus(fields[5]);
        Books.add(this);
    }

    public static void bookReadFromFile() throws IOException {
        File bookFile = new File("D:\\Java\\Tutorials\\glLibrary\\src\\Book.txt");
        Scanner bookFileReader = new Scanner(bookFile);
        while (bookFileReader.hasNextLine()) {
            new Book(bookFileReader.nextLine());
        }
    }

    public static void bookPrintAll() {
        String separator = System.lineSeparator();
        System.out.println("======================================================================");
        System.out.println(" Books ");
        for (int i = 0; i < Books.size(); i++) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            System.out.println(Books.get(i).toString().replace("\\n", separator));
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

    public void setBookId(String newBookId) {
        bookId = newBookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookName(String newBookName) {
        bookName = newBookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookCategory(String newBookCategory) {
        bookCategory = newBookCategory;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookWriter(String newBookWriter) {
        bookWriter = newBookWriter;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookShortStory(String newBookShortStory) {
        bookShortStory = newBookShortStory;
    }

    public String getBookShortStory() {
        return bookShortStory;
    }

    public void setBookStatus(String newBookStatus) {
        bookStatus = newBookStatus;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public String toString() {
        return "CATEGORY:" + bookCategory + "   ID: " + bookId + "   NAME: " + bookName + "   WRITER: " + bookWriter + "\n"
        + "Short Story: " + bookShortStory.toString();
    }



    public static void main(String[] args) {

    }
}
