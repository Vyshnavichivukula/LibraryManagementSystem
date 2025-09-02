import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Add some sample books
        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book id to borrow: ");
                    int borrowId = sc.nextInt();
                    Book b1 = library.findBookById(borrowId);
                    if (b1 != null) b1.borrowBook();
                    else System.out.println("Book not found.");
                    break;
                case 3:
                    System.out.print("Enter book id to return: ");
                    int returnId = sc.nextInt();
                    Book b2 = library.findBookById(returnId);
                    if (b2 != null) b2.returnBook();
                    else System.out.println("Book not found.");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);

        sc.close();
    }
}
