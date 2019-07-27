package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

@Repository

public class BookRepository extends GenericDAO<Book> {
    public BookRepository() {
        super(Book.class);
    }
}
