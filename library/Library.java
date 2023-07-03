package library;

import java.util.ArrayList;
import java.util.List;

public class Library implements FeatureLibrary{
    List<Book> books;

    public Library () {
        this.books = new ArrayList<>();
    }
    @Override
    public boolean add(Book book) {
        if (this.books != null) {
            boolean hasBook = false;
            for (Book bookName: this.books) {
                if (bookName.title == book.title) {
                    hasBook = true;
                }
            }
            if (!hasBook) {
                this.books.add(book);
                return true;
            }
        } else {
            this.books.add(book);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(BookProp prop) {
        return false;
    }

    @Override
    public boolean removeByAuthor(String author) {
        int size = this.books.size();
        boolean hasBook = false;
        for (int index = 0; index < size; index++) {
            if ( this.books.get(index).author == author) {
                this.books.remove(index);
                hasBook = true;
            }
        }
        if (hasBook) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeByTitle(String title) {
        boolean hasBook = false;
        for (int index = 0; index < this.books.size(); index++) {
            if ( this.books.get(index).title == title) {
                this.books.remove(index);
                hasBook = true;
            }
        }
        if (hasBook) {
            return true;
        }
        return false;
    }

    public List<Book> getBooks() {
        return books;
    }
}
