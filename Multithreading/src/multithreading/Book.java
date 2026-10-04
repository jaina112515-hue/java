package multithreading;
class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;

    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author + " | " + category;
    }
}

// Borrow request class
class BorrowRequest {
    private String studentName;
    private int bookId;

    public BorrowRequest(String studentName, int bookId) {
        this.studentName = studentName;
        this.bookId = bookId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return studentName + " requested Book ID " + bookId;
    }
}
