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
    public static void main(String[] args) {
        String msg = "";
        Book myBook;
        double price = 0.0;
        int noBooks = 0;

        ArrayList<Book> bookInventory = new ArrayList<Book>();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many books do you want to enter?");
        int bookNo =  keyboard.nextInt();
        keyboard.nextLine();                     // skip to next line

        for (int i = 0; i < bookNo; i++) {
            myBook = new Book();
            System.out.println("Enter a title for book #" + (i+1));
            msg = keyboard.nextLine();
            myBook.setTitle(msg);

            System.out.println("Enter an author");
            msg = keyboard.nextLine();
            myBook.setAuthor(msg);

            System.out.println("Enter a description");
            msg = keyboard.nextLine();
            myBook.setDescription(msg);

            System.out.println("Enter a price");
            price = keyboard.nextDouble();
            myBook.setPrice(price);

            System.out.println("Enter a number of books");
            noBooks = keyboard.nextInt();
            keyboard.nextLine();
            myBook.setInStock(noBooks);

            bookInventory.add(myBook);
        }

        for (int i = 0; i < bookInventory.size(); i++){
            myBook = bookInventory.get(i);
            myBook.printBookInfo();

        }
    }
}
