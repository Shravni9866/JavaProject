
import java.util.Scanner;
import java.io.*;
import java.util.*;



class Book {
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Override toString for easy display
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        loadBooksFromFile(); // Load books from a file
    }

    // Add a book
    public void addBook(String title, String author, String genre) {
        books.add(new Book(title, author, genre));
        saveBooksToFile();
    }

    // Remove a book
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        saveBooksToFile();
    }

    // Issue a book
    public boolean issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false); // Mark as issued
                saveBooksToFile();
                return true;
            }
        }
        return false; // Book not available
    }

    // Return a book
    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true); // Mark as returned
                saveBooksToFile();
                return true;
            }
        }
        return false; // Book not found or already available
    }

    // Search books
    public List<Book> searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    // Display all books
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Load books from a file
    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                String genre = parts[2].trim();
                books.add(new Book(title, author, genre));
            }
        } catch (IOException e) {
            System.out.println("Error loading books from file.");
        }
    }

    // Save books to a file
    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getGenre() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving books to file.");
        }
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Books");
            System.out.println("6. View All Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book genre: ");
                    String genre = scanner.nextLine();
                    library.addBook(title, author, genre);
                    System.out.println("✅ Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    library.removeBook(title);
                    System.out.println("✅ Book removed successfully.");
                    break;

                case 3:
                    System.out.print("Enter book title to issue: ");
                    title = scanner.nextLine();
                    if (library.issueBook(title)) {
                        System.out.println("✅ Book issued successfully.");
                    } else {
                        System.out.println("❌ Book is unavailable or does not exist.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    if (library.returnBook(title)) {
                        System.out.println("✅ Book returned successfully.");
                    } else {
                        System.out.println("❌ Book does not exist or was not issued.");
                    }
                    break;

                case 5:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    var foundBooks = library.searchBooks(keyword);
                    if (foundBooks.isEmpty()) {
                        System.out.println("❌ No books found.");
                    } else {
                        System.out.println("Found books:");
                        foundBooks.forEach(System.out::println);
                    }
                    break;

                case 6:
                    library.displayBooks();
                    break;

                case 7:
                    System.out.println("👋 Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

