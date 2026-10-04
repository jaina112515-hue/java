
package multithreading;

import java.util.*;

public class Multithreading {

    
    static class Book {
        int id;
        String title;
        String author;
        String category;

        Book(int id, String title, String author, String category) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.category = category;
        }

        @Override
        public String toString() {
            return id + " | " + title + " | " + author + " | " + category;
        }
    }

    
    static class BorrowRequest {
        String studentName;
        int bookId;

        BorrowRequest(String studentName, int bookId) {
            this.studentName = studentName;
            this.bookId = bookId;
        }
    }

    

    static List<Book> books = new ArrayList<>();

    static Set<String> categories = new HashSet<>();

    static Map<Integer, Book> bookMap = new HashMap<>();

    static Queue<BorrowRequest> requests = new LinkedList<>();


    
    static void addBook(Book book) {

        books.add(book);
        bookMap.put(book.id, book);
        categories.add(book.category);
    }


    static void displayBooks() {

        System.out.println("\n========== AVAILABLE BOOKS ==========");

        for (Book book : books) {
            System.out.println(book);
        }
    }


    
    static void displayCategories() {

        System.out.println("\n========== BOOK CATEGORIES ==========");

        for (String category : categories) {
            System.out.println(category);
        }
    }


    
    static void searchBook(int id) {

        System.out.println("\n========== SEARCH BOOK ==========");

        Book book = bookMap.get(id);

        if (book != null) {
            System.out.println("Book Found:");
            System.out.println(book);
        } else {
            System.out.println("Book Not Found");
        }
    }


    
    static void addRequest(String studentName, int bookId) {

        requests.offer(new BorrowRequest(studentName, bookId));

        System.out.println(
                "Request added: "
                + studentName
                + " wants Book ID "
                + bookId
        );
    }


    
    static void processRequests() {

        System.out.println("\n========== PROCESSING REQUESTS ==========");

        List<Thread> threads = new ArrayList<>();

        while (!requests.isEmpty()) {

            BorrowRequest request = requests.poll();

            Thread thread = new Thread(() -> {

                System.out.println(
                        Thread.currentThread().getName()
                        + " processing request for "
                        + request.studentName
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }

                Book book = bookMap.get(request.bookId);

                if (book != null) {

                    System.out.println(
                            "SUCCESS: "
                            + request.studentName
                            + " borrowed "
                            + book.title
                    );

                } else {

                    System.out.println(
                            "FAILED: Book ID "
                            + request.bookId
                            + " not found."
                    );
                }
            });

            threads.add(thread);
            thread.start();
        }


        
        for (Thread thread : threads) {

            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }


    
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       LIBRARY MANAGEMENT SYSTEM");
        System.out.println("==========================================");


        
        addBook(new Book(
                101,
                "Java Programming",
                "Herbert Schildt",
                "Programming"
        ));

        addBook(new Book(
                102,
                "Data Structures",
                "Mark Allen Weiss",
                "Computer Science"
        ));

        addBook(new Book(
                103,
                "Database Management",
                "Raghu Ramakrishnan",
                "Database"
        ));

        addBook(new Book(
                104,
                "Computer Networks",
                "Andrew Tanenbaum",
                "Networking"
        ));

        addBook(new Book(
                105,
                "Python Programming",
                "Eric Matthes",
                "Programming"
        ));


        
        displayBooks();


        
        displayCategories();


        
        searchBook(103);


        
        System.out.println("\n========== BORROW REQUESTS ==========");

        addRequest("Emi", 101);
        addRequest("Rahul", 103);
        addRequest("Priya", 105);
        addRequest("Arun", 102);


       
        processRequests();


        System.out.println("\n==========================================");
        System.out.println("          PROGRAM COMPLETED");
        System.out.println("==========================================");
    }
}

