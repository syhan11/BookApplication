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

        System.out.println("How many books do you want to enter?");
        int bookNo = keyboard.nextInt();
        keyboard.nextLine();                     // skip to next line

        initInventory(bookNo, keyboard);         // initialize book inventory array
        printInventory();

        int max = 5;
        double sum = 0.0;
        Book myBook;
        String msg;
        boolean flag = true;

        do {
            System.out.println("\nWhich title are you interested in? Type 'Q' to quit.");
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
                    System.out.println("Can not find the title, " + msg);
            }

        } while (flag);
    }

    public static void initInventory(int valMax, Scanner varInput) {
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

    public static Book searchBook(String varTitle) {
        boolean found = false;
        Book myBook = null;


        for (Book tmpBook : bookInventory)
            if (varTitle.equalsIgnoreCase(tmpBook.getTitle())) {
                //found = true;
                myBook = tmpBook;
                break;
            }

        return myBook;
    }
}
