public class Book {
    private String keySKU;
    private String title;
    private String author;
    private String description;
    private double price;
    private int numbInStock;


    public Book() {
        this.keySKU = "";
        this.title = "";
        this.author = "";
        this.description = "";
        this.price = 0.0;
        this.numbInStock = 0;
    }

    public Book(String keySKU, String title, String author, String description,
                           double price, int numbInStock) {
        this.keySKU = keySKU;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.numbInStock = numbInStock;
    }

    public String getkeySKU() {
        return keySKU;
    }

    public void setkeySKU(String keySKU) {
        this.keySKU = keySKU;
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
     *  It takes no parameters.
     *  When called it returns a string containing the author, title and description.
     */
    public String getDisplayText() {
        String msg = "";
        msg = title + " written by " + author + " is about " + description;
        return msg;
    }

    public void printBookInfo() {

        System.out.println(getDisplayText());
        System.out.printf("SKU: %s\tPrice: $%.2f\tAvailable: %d\n", keySKU, price, numbInStock);

    }

}
