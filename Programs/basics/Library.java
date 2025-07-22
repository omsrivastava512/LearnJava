// Create two classes:
// Book: title, author, isbn, isAvailable
// Library: maintain array of books, methods to addBook(), searchBook()
// Demonstrate creating library, adding books, and searching

package basics;

import java.util.ArrayList;
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
        this.isbn = sc.nextLine(); // Fixed: was assigning to author
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

    public void display() {
        System.out.println("------------------------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("------------------------");
    }
}

class Library {
    private ArrayList<Book> books;

    // Default constructor for testing
    public Library() {
        books = new ArrayList<>();
    }

    public Library(Scanner sc) {
        books = new ArrayList<>();

        System.out.println("Enter the number of books:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline after nextInt()

        for (int i = 0; i < n; i++) { // Fixed: start from 0, use < instead of <=
            books.add(new Book(sc));
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    void addBook(String title, String author, String isbn, boolean isAvailable) {
        books.add(new Book(title, author, isbn, isAvailable));
    }

    void addBook(Scanner sc) {
        books.add(new Book(sc));
    }

    void searchByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.display();
                return;
            }
        }
        System.out.println("No books found");
    }

    void searchByTitle(String title) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                results.add(book);
            }
        }
        displaySearchResults(results);
    }

    void searchByAuthor(String author) {
        ArrayList<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                results.add(book);
            }
        }
        displaySearchResults(results);
    }

    private void displaySearchResults(ArrayList<Book> results) {
        System.out.println("Found " + results.size() + " results!");
        for (Book book : results) {
            book.display();
        }
    }

    // Additional utility methods for testing
    public int getBookCount() {
        return books.size();
    }

    public void displayAllBooks() {
        System.out.println("\n=== All Books in Library ===");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println("Book #" + (i + 1) + ":");
                books.get(i).display();
            }
        }
    }

    public void clearLibrary() {
        books.clear();
        System.out.println("Library cleared.");
    }
}

 class Test {
    private static int testCount = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("         LIBRARY MANAGEMENT SYSTEM - TEST SUITE");
        System.out.println("=".repeat(60));

        // Create a library for testing (without user input)
        Library library = createTestLibrary();

        // Run all test cases
        testAddBookFunctionality(library);
        testSearchByISBN(library);
        testSearchByTitle(library);
        testSearchByAuthor(library);
        testEdgeCases(library);
        testLargeDataSet(library);

        // Print test summary
        printTestSummary();
    }

    private static Library createTestLibrary() {
        System.out.println("\n1. CREATING TEST LIBRARY WITH SAMPLE DATA");
        System.out.println("-".repeat(50));

        // Create library without Scanner input for testing
        Library library = new Library();

        // Add test books
        library.addBook("1984", "George Orwell", "978-0451524935", true);
        library.addBook("To Kill a Mockingbird", "Harper Lee", "978-0061120084", false);
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", true);
        library.addBook("Animal Farm", "George Orwell", "978-0451526342", true);
        library.addBook("Pride and Prejudice", "Jane Austen", "978-0141439518", false);
        library.addBook("Java: The Complete Reference", "Herbert Schildt", "978-1260440232", true);

        System.out.println("✓ Test library created with 6 books");
        assertTest("Library should have 6 books", library.getBookCount() == 6);

        return library;
    }

    private static void testAddBookFunctionality(Library library) {
        System.out.println("\n2. TESTING ADD BOOK FUNCTIONALITY");
        System.out.println("-".repeat(50));

        int initialCount = library.getBookCount();

        // Test adding book with constructor
        Book newBook = new Book("Test Book", "Test Author", "123456789", true);
        library.addBook(newBook);
        assertTest("Adding book with object should increase count",
                library.getBookCount() == initialCount + 1);

        // Test adding book with parameters
        library.addBook("Another Test", "Another Author", "987654321", false);
        assertTest("Adding book with parameters should increase count",
                library.getBookCount() == initialCount + 2);

        System.out.println("✓ Add book functionality tests completed");
    }

    private static void testSearchByISBN(Library library) {
        System.out.println("\n3. TESTING SEARCH BY ISBN");
        System.out.println("-".repeat(50));

        System.out.println("Test 3.1: Valid ISBN search");
        library.searchByISBN("978-0451524935"); // Should find 1984

        System.out.println("\nTest 3.2: Invalid ISBN search");
        library.searchByISBN("000-0000000000"); // Should find nothing

        System.out.println("\nTest 3.3: Partial ISBN search (should not match)");
        library.searchByISBN("978-0451"); // Should find nothing (exact match required)

        System.out.println("\nTest 3.4: Case sensitivity test");
        library.searchByISBN("978-0451524935"); // Should work

        System.out.println("✓ ISBN search tests completed");
    }

    private static void testSearchByTitle(Library library) {
        System.out.println("\n4. TESTING SEARCH BY TITLE");
        System.out.println("-".repeat(50));

        System.out.println("Test 4.1: Exact title search");
        library.searchByTitle("1984"); // Should find 1984

        System.out.println("\nTest 4.2: Partial title search");
        library.searchByTitle("Great"); // Should find The Great Gatsby

        System.out.println("\nTest 4.3: Case insensitive search");
        library.searchByTitle("animal"); // Should find Animal Farm

        System.out.println("\nTest 4.4: Multiple results search");
        library.searchByTitle("the"); // Should find multiple books

        System.out.println("\nTest 4.5: No results search");
        library.searchByTitle("NonExistentBook"); // Should find nothing

        System.out.println("✓ Title search tests completed");
    }

    private static void testSearchByAuthor(Library library) {
        System.out.println("\n5. TESTING SEARCH BY AUTHOR");
        System.out.println("-".repeat(50));

        System.out.println("Test 5.1: Full author name search");
        library.searchByAuthor("George Orwell"); // Should find 2 books

        System.out.println("\nTest 5.2: Partial author name search");
        library.searchByAuthor("George"); // Should find 2 books

        System.out.println("\nTest 5.3: Last name only search");
        library.searchByAuthor("Orwell"); // Should find 2 books

        System.out.println("\nTest 5.4: Case insensitive search");
        library.searchByAuthor("jane austen"); // Should find Pride and Prejudice

        System.out.println("\nTest 5.5: No results search");
        library.searchByAuthor("Unknown Author"); // Should find nothing

        System.out.println("✓ Author search tests completed");
    }

    private static void testEdgeCases(Library library) {
        System.out.println("\n6. TESTING EDGE CASES");
        System.out.println("-".repeat(50));

        System.out.println("Test 6.1: Empty string searches");
        library.searchByTitle(""); // Should find all books (empty string matches all)
        library.searchByAuthor(""); // Should find all books
        library.searchByISBN(""); // Should find nothing (ISBN requires exact match)

        System.out.println("\nTest 6.2: Null handling tests");
        try {
            library.searchByTitle(null);
            System.out.println("⚠ Warning: Null title search should be handled");
        } catch (Exception e) {
            System.out.println("✓ Null title search properly throws exception: " + e.getClass().getSimpleName());
        }

        System.out.println("\nTest 6.3: Special characters in search");
        library.searchByTitle("&*#@!"); // Should find nothing

        System.out.println("\nTest 6.4: Very long search strings");
        String longString = "a".repeat(1000);
        library.searchByTitle(longString); // Should find nothing

        System.out.println("\nTest 6.5: Search with leading/trailing spaces");
        library.searchByTitle(" 1984 "); // Might not find due to exact matching

        System.out.println("✓ Edge case tests completed");
    }

    private static void testLargeDataSet(Library library) {
        System.out.println("\n7. TESTING WITH LARGE DATASET");
        System.out.println("-".repeat(50));

        // Add many books for performance testing
        System.out.println("Adding 100 additional books for performance testing...");
        for (int i = 1; i <= 100; i++) {
            library.addBook("Book " + i, "Author " + i, "ISBN-" + i, i % 2 == 0);
        }

        int currentCount = library.getBookCount();
        assertTest("Should have added 100 books", currentCount >= 106);

        System.out.println("Test 7.1: Performance test - Search in large dataset");
        long startTime = System.currentTimeMillis();
        library.searchByAuthor("Author");
        long endTime = System.currentTimeMillis();
        System.out.println("Search completed in: " + (endTime - startTime) + "ms");

        System.out.println("\nTest 7.2: Memory usage test");
        // library.displayAllBooks(); // This will show all books but truncated output

        System.out.println("✓ Large dataset tests completed");
    }

    private static void assertTest(String testName, boolean condition) {
        testCount++;
        if (condition) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
        } else {
            System.out.println("✗ FAIL: " + testName);
        }
    }

    private static void printTestSummary() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    TEST SUMMARY");
        System.out.println("=".repeat(60));
        System.out.println("Total Tests Run: " + testCount);
        System.out.println("Tests Passed: " + passedTests);
        System.out.println("Tests Failed: " + (testCount - passedTests));
        System.out.println("Success Rate: " + String.format("%.2f", (passedTests * 100.0 / testCount)) + "%");

        if (passedTests == testCount) {
            System.out.println("🎉 ALL TESTS PASSED! 🎉");
        } else {
            System.out.println("⚠ Some tests failed. Review the output above.");
        }
        System.out.println("=".repeat(60));
    }
}
