public class DouglasJoshuaAssignment10 {
    public static void main(String[] args) {

        // Initializing each book as an object and placing each book object in array bookArray[]
        Book book1 = new Book("Big java: Early Objects", "Clay Horstman", 708);
        Book book2 = new Book("Grokking Algorithms", "Aditya Bhargava", 238);
        Book book3 = new Book("The C++ Programming Language", "Bjarne Stroustrup", 1376);
        Book book4 = new Book("The Elements of Java Style", "Jim Shur", 144); 
        Book book5 = new Book("The Design of Everyday Things", "Don Norman", 368);
        Book book6 = new Book("Dont Make Me Think", "Steve Krug", 216);

        Book bookArray[] = {book1, book2, book3, book4, book5, book6};
       
        // Part 1, displaying the books in the previously created array bookArray[]
        System.out.println("***********************************************************");
        System.out.println("                Part 1: Books in Array Main                ");
        System.out.println("***********************************************************");
        System.out.println();
        System.out.printf("%10s%25s%24s\n", "Author", "Title", "# Of Pages");
        System.out.println("-----------------------------------------------------------");
       
        // Calls on methods created in book class to display info
        for (int i = 0; i < bookArray.length; i++) {
             System.out.printf("%-20s%-32s%-10d\n", bookArray[i].getAuthor(), bookArray[i].getTitle(), bookArray[i].getNumPages());
         }
       
        // Find the smallest book by comparing the number of pages in each book object in array bookArray[] 
        Book smallestBook = null;

         for(int i = 0; i < bookArray.length; i++) {

             if(smallestBook == null || bookArray[i].getNumPages() < smallestBook.getNumPages()) {
                smallestBook = bookArray[i];
             }
         } 
       
        // Display the smallest book and its details to the user
        System.out.println(); 
        System.out.println("Book with smallest number of pages");
        System.out.println("----------------------------------");
        System.out.println("Author: " + smallestBook.getAuthor());
        System.out.println("Title: " + smallestBook.getTitle());
        System.out.println("Number of Pages: " + smallestBook.getNumPages());
       

        // Part 2: Creating a library object and adding our books from part 1 into it
        System.out.println();
        System.out.println("***********************************************************");
        System.out.println("                Part 2: Books in Library                   ");
        System.out.println("***********************************************************");
       
        Library myLibrary = new Library(5);
       
        // For loop adds books to object until it reaches maxNumBooks and sets bookAdded to false
        for (int i = 0; i < bookArray.length; i++) {

            boolean bookAdded = myLibrary.addBook(bookArray[i]);

            if (bookAdded) {
                System.out.println(bookArray[i].getTitle() + " added to library = " + bookAdded);
            }

            else {
                System.out.println(bookArray[i].getTitle() + " added to library = " + bookAdded);
            }

        }
        // Displaying books in library and printing info of smallest book in the library
        myLibrary.displayBooks();

        System.out.println(); 
        System.out.println("Book with smallest number of pages");
        System.out.println("----------------------------------");
        System.out.println("Author: " + myLibrary.findSmallestBook().getAuthor());
        System.out.println("Title: " + myLibrary.findSmallestBook().getTitle());
        System.out.println("Number of Pages: " + myLibrary.findSmallestBook().getNumPages());

    }
}

// Class to define what data is stored in a book object and how its constructed
class Book {

    private String title;
    private String author;
    private int numPages;

    // Constructor that assigns actual paramaters to book variables
    public Book(String title, String author, int numPages) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
    }

    // Returns title of selected book
    public String getTitle() {
        return title;
    }

    // Returns author of selected book
    public String getAuthor() {
        return author;
    }

    // Returns number of pages of selected book
    public int getNumPages() {
        return numPages;
    }
}

// Class to define what data is stored in a library object and how its constructed
class Library {

    private Book books[];
    private int numBooksInLibrary;

    // Constructor that takes the maximum number of books the library can store and assigns it to the books object
    public Library(int maxNumBooks) {
        books = new Book[maxNumBooks];
        numBooksInLibrary = 0;
    }

    // Method to add books to the library until the maximum is reached when it will return addedBook as false
    public boolean addBook(Book bookToAdd) {

        boolean addedBook;

        if (numBooksInLibrary < books.length) {

            books[numBooksInLibrary] = bookToAdd;
            addedBook = true;
            numBooksInLibrary += 1;
        }

        else {
            addedBook = false;
        }

        return addedBook;
    }

    // Method that compares the length of each book in the library and returns the smallest as a Book object
    public Book findSmallestBook() {

        Book smallestBook = null;

        for(int i = 0; i < numBooksInLibrary; i++) {

            if (smallestBook == null || books[i].getNumPages() < smallestBook.getNumPages()) {

                smallestBook = books[i];
            }

        }

        return smallestBook;
    }

    // Method to print the details of only the books stored in the library 
    public void displayBooks() {
        System.out.println();
        System.out.println("------------------------ My Library -----------------------");
        System.out.println();
        System.out.printf("%10s%22s%27s\n", "Author", "Title", "# Of Pages");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < numBooksInLibrary; i++) {
            System.out.printf("%-20s%-32s%-10d\n", books[i].getAuthor(), books[i].getTitle(), books[i].getNumPages());
        }
        
    }

}
