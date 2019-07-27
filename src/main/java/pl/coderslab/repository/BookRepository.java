package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookRepoCustom {

    //1-2 task
    List<Book> findByTitle(String title);
    //mapujemy na title nawet jeżeli napiszemy sobie że kolumna ma nazywać się inaczej
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long id);

    //1-3 task
    List<Book> findByAuthors(Author author);
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByRatingBetween(Integer a, Integer b);
    Book findFirstByCategoryOrderByTitle(Category category);


    //2-1 task
    @Query("select b from Book b where b.title = :title")
    List <Book> findByTitle2(@Param("title") String title);
    @Query("select b from Book b where b.category = :category")
    List <Book> findByTitle2(@Param("category") Category category);

    //2-2 task
    @Query("select b from Book b where b.rating between :max and :min")
    List<Book> bookRaitingBetween(@Param("max") Integer min, @Param("min") Integer max);
    @Query("select b from Book b where b.publisher = :publisher")
    List<Book> booksFromPublisher(@Param("publisher") Publisher publisher);
    @Query(value = "SELECT * FROM books WHERE category_id = :category.id Order by myTitle limit=1", nativeQuery = true)
    Book oneBookFromCategory(@Param("category") Category category);


}
