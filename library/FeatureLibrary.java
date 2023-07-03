package library;

public interface FeatureLibrary {
    boolean add(Book book);
    boolean removeByTitle(String title);
    boolean removeByAuthor(String author);
    
    // Bài tập nâng cao (optional)
    boolean remove(BookProp prop);
}
