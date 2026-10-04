/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Jaina
 */
public class LibraryManagementSystem {
     // List - stores all books
    private static List<Book> bookList = new ArrayList<>();

    // Map - maps Book ID to Book
    private static Map<Integer, Book> bookMap = new HashMap<>();

    // Set - stores unique categories
    private static Set<String> categories = new HashSet<>();

    // Queue - stores borrowing requests
    private static Queue<BorrowRequest> borrowQueue = new LinkedList<>();

    // Add book method
    public static void addBook(Book book) {
        bookList.add(book);
        bookMap.put(book.getBookId(), book);
        categories.add(book.getCategory());
    }

    // Display all books
    public static void displayBooks() {
        System.out.println("\n========== AVAILABLE BOOKS ==========");

        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    // Display categories
    public static void displayCategories() {
        System.out.println("\n========== BOOK CATEGORIES ==========");

        for (String category : categories) {
            System.out.println(category);
        }
    }

    // Search book using Map
    public static void searchBook(int bookId) {
        System.out.println("\n========== SEARCH BOOK ==========");

        Book book = bookMap.get(bookId);

        if (book != null) {
            System.out.println("Book Found:");
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Add borrowing request
    public static void addBorrowRequest(String studentName, int bookId) {
        BorrowRequest request = new BorrowRequest(studentName, bookId);
        borrowQueue.offer(request);

        System.out.println("Borrow request added: " + request);
    }

    // Multithreading - process borrowing requests
    public static void processBorrowRequests() {

        System.out.println("\n========== PROCESSING BORROW REQUESTS ==========");

        List<Thread> threads = new ArrayList<>();

        while (!borrowQueue.isEmpty()) {

            BorrowRequest request = borrowQueue.poll();

            Thread thread = new Thread(() -> {

                System.out.println(
                    Thread.currentThread().getName()
                    + " is processing: "
                    + request
                );

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }

                Book book = bookMap.get(request.getBookId());

                if (book != null) {
                    System.out.println(
                        "Request completed: "
                        + request.getStudentName()
                        + " borrowed \"" 
                        + book.getTitle() 
                        + "\""
                    );
                } else {
                    System.out.println(
                        "Book ID " 
                        + request.getBookId() 
                        + " is not available."
                    );
                }
            });

            threads.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    
}
