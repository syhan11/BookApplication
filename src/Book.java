public class Book {

    private String title;
    private String author;
    private String description;
    private double price;
    private int numbInStock;


    public Book() {
        this.title = "";
        this.author = "";
        this.description = "";
        this.price = 0.0;
        this.numbInStock = 0;
    }

    public Book(String title, String author, String description,
                           double price, int numbInStock) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.numbInStock = numbInStock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        if (numbInStock > 0)
             return true;
        else
            return false;
    }

    public int getInStock() {
        return numbInStock;
    }

    public void setInStock(int numbInStock) {
        this.numbInStock = numbInStock;
    }

    /*
     * getDisplayText() prints the author, title and description of a book.
     */
    public void getDisplayText() {
        System.out.printf("%s written by %s is about %s\n", title, author, description);
    }

    public void printBookInfo() {
        System.out.printf("\"%s\" written by %s is about %s\n", title, author, description);
        System.out.printf("Price:\t$%.2f\tAvailable:%d\n", price, numbInStock);
    }

}
