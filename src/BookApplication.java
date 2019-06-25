/*
 * Create a project in IntelliJ called BookApplication.
 * Create a Book class that allows for Book title, author, description, price and
 * isInStock variables
 * The Book class shall contain private member variables, a default constructor,
 * an overloaded constructor and a method called getDisplayText() which
 * prints the author, title and description.
 *
 * The application shall also contain getters and setters for each private member
 * variable.
 *
 * Create another class called BookApp which contains the main method.
 * In the main method you shall create an instance of a Book and print the Author,
 * Title and Description.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class BookApplication {
    static ArrayList<Book> bookInventory = new ArrayList<Book>();

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        initInventory();                         // initialize the book inventory

        /*
        System.out.println("How many books do you want to add to the book inventory?");
        int bookNo = keyboard.nextInt();
        keyboard.nextLine();                     // skip to next line

        addInventory(bookNo, keyboard);         // add book to the inventory array
        */

        printInventory();

        int max = 5;
        double sum = 0.0;
        Book myBook;
        String msg;
        boolean flag = true;

        do {
            System.out.println("\nWhich SKU are you interested in? Type 'Q' to quit.");
            msg = keyboard.nextLine();

            if (msg.equalsIgnoreCase("Q"))
                flag = false;
            else {
                myBook = searchBook(msg);
                if (myBook != null) {
                    System.out.println("How many books do you want?");
                    max = keyboard.nextInt();
                    keyboard.nextLine();
                    sum = checkPrice(myBook, max);
                    if (sum > 0)
                        System.out.printf("Price of %d books is $%,.2f\n", max, sum);
                    else
                        System.out.printf("Not enough books.  There are only %d books left.\n", myBook.getInStock());

                } else
                    System.out.println("Can not find the SKU, " + msg);
            }

        } while (flag);
    }

    /*
     * Initialize the book inventory.  For now, all books have 10 copies.
     */
    public static void initInventory() {
        Book myBook;

        myBook = new Book("Java1001","Head First Java","Kathy Sierra and Bert Bates",
                           "Easy to read Java workbook", 47.50, 10);
        bookInventory.add(myBook);

        myBook = new Book("Java1002", "Thinking in Java", "Bruce Eckel",
                          "Details about Java under the hood", 20.00, 10);
        bookInventory.add(myBook);

        myBook = new Book("Orcl1003","OCP: Oracle Certified Professional Java SE","Jeanne Boyarsky",
                          "Everything you need to know in one place",45.00, 10);
        bookInventory.add(myBook);

        myBook = new Book("Python1004	","Automate the Boring Stuff with Python","Al Sweigart",
                          "Fun with Python", 10.50, 10);
        bookInventory.add(myBook);

        myBook = new Book("Zombie1005", "The Maker's Guide to the Zombie Apocalypse", "Simon Monk",
                          "Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi", 16.50, 10);
        bookInventory.add(myBook);

        myBook = new Book("Rasp1006", "Raspberry Pi Projects for the Evil Genius", "Donald Norris",
                          "A dozen fiendishly fun projects for the Raspberry Pi!", 14.75, 10);
        bookInventory.add(myBook);
    }

    public static void addInventory(int valMax, Scanner varInput) {
        Book myBook;
        String msg;
        double price = 0.0;
        int noBooks = 0;


        for (int i = 0; i < valMax; i++) {
            myBook = new Book();
            System.out.println("Enter a title for book #" + (i + 1));
            msg = varInput.nextLine();
            myBook.setTitle(msg);

            System.out.println("Enter an author");
            msg = varInput.nextLine();
            myBook.setAuthor(msg);

            System.out.println("Enter a description");
            msg = varInput.nextLine();
            myBook.setDescription(msg);

            System.out.println("Enter a price");
            price = varInput.nextDouble();
            myBook.setPrice(price);

            System.out.println("Enter a number of books");
            noBooks = varInput.nextInt();
            varInput.nextLine();
            myBook.setInStock(noBooks);

            bookInventory.add(myBook);
        }

    }

    public static void printInventory() {
        Book myBook;

        for (int i = 0; i < bookInventory.size(); i++) {
            System.out.println();
            myBook = bookInventory.get(i);
            myBook.printBookInfo();
        }

    }

    public static double checkPrice(Book valBook, int valNo) {
        double sum = 0.0;

        if (valNo <= valBook.getInStock()) {
            sum = valNo * valBook.getPrice();
        }

        return sum;

    }

    /*
     * Search for a given SKU value in the bookInventory array
     * It will return the Book if found
     * Otherwise it will return null value
     */
    public static Book searchBook(String varSKU) {
        boolean found = false;
        Book myBook = null;


        for (Book tmpBook : bookInventory)
            if (varSKU.equalsIgnoreCase(tmpBook.getkeySKU())) {
                //found = true;
                myBook = tmpBook;
                break;
            }

        return myBook;
    }
}
