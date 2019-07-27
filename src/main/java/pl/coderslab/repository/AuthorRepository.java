package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    //task 1-5
    Author findByEmail (String email);
    Author findByPesel (String pesel);
    List<Author> findByLastName (String lastName);

    //task 2-3
    @Query("select a from Author a where a.email like :first%")
    List<Author> authorThatHasEmailLike (@Param("first") String first);
    @Query("select a from Author a where a.pesel like :first%")
    List<Author> authorThatHasPeselLike (@Param("first") String first);
}
