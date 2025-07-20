// Create two classes:
// Book: title, author, isbn, isAvailable
// Library: maintain array of books, methods to addBook(), searchBook()
// Demonstrate creating library, adding books, and searching

package basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Book {
    String title, author, isbn;
    boolean isAvailable;

    public Book(Scanner sc) {
        System.out.println("Enter title of the books:");
        this.title = sc.nextLine();
        System.out.println("Enter author name:");
        this.author = sc.nextLine();
        System.out.println("Enter ISBN:");
        this.author = "" + sc.nextInt();
        System.out.println("Enter Availability (Y/N):");
        char avl = sc.next().charAt(0);
        this.isAvailable = (avl == 'Y' || avl == 'y');
        sc.nextLine();
    }

    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void display(){
        System.out.println("------------------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("------------------------");
    }
}

public class Library {
    private int bookCount = 0;
    private ArrayList<Book> books;

    public Library(Scanner sc) {
        books = new ArrayList<>();

        System.out.println("Enter the number of books:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline after nextInt()

        for (int i = 1; i <= n; i++) {
            Book newBook = new Book(sc);
            books.add(newBook);
            bookCount++;
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    void addBook(String title, String author, String isbn, boolean isAvailable) {
        books.add(new Book(title, author, isbn, isAvailable));
        bookCount++;
    }

    void addBook(Scanner sc) {
        books.add(new Book(sc));
        bookCount++;
    }

    void searchByISBN(String isbn){
        for(int i = 1; i<=bookCount; i++){
            if(books.get(i).getIsbn().equals(isbn)){
                books.get(i).display();
                return;
            }
        }
    }

    

    void searchByTitle(String title) {
        int res = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 1; i<=bookCount; i++){
            if(books.get(i).getTitle().contains(title)){
                indices.add(i);
                res++;
            }
        }
        System.out.println("Found " + res + " results!");
        Iterator<Integer> indexIterator = indices.iterator();
        while(indexIterator.hasNext()){
            books.get(indexIterator.next()).display();
        }
    }

    void searchByAuthor(String author) {
        int res = 0;
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 1; i<=bookCount; i++){
            if(books.get(i).getAuthor().contains(author)){
                indices.add(i);
                res++;
            }
        }
        System.out.println("Found " + res + " results!");
        Iterator<Integer> indexIterator = indices.iterator();
        while(indexIterator.hasNext()){
            books.get(indexIterator.next()).display();
        }
    }
}
